package Pipeline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import TwitterReader.type.RawTweet;
import de.tudarmstadt.ukp.dkpro.core.api.io.JCasResourceCollectionReader_ImplBase;
import de.unihd.dbs.uima.types.heideltime.Dct;



public class TwitterReader extends JCasResourceCollectionReader_ImplBase{

	public static final String PARAM_ENCODING = "encoding";
    @ConfigurationParameter(name = PARAM_ENCODING, mandatory = true, defaultValue = "UTF-8")
    private String encoding;

    public static final String PARAM_REMOVE_TWITTER_PHENOMENONS = "PARAM_REMOVE_TWITTER_PHENOMENONS";
    @ConfigurationParameter(name = PARAM_REMOVE_TWITTER_PHENOMENONS, mandatory = true, defaultValue = "false")
    private boolean removeTwitterPhenomenons;

    int currentReaderIdx = 0;
    private static String[] filePaths = null;
    private static String nextLine = null;
    private BufferedReader reader = null;

    private static final String CREATE_MARKER = "\"created_at\"";
    private static final String TEXT_MARKER = "\"text\":\"";
    private static final String MARKER_END = "\",";

    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        initFileStreamsForAllFiles();
    }

    private void initFileStreamsForAllFiles()
    {
        List<String> files = new ArrayList<String>();
        try {
            for (Resource r : getResources()) {
                files.add(r.getResource().getFile().getAbsolutePath());
            }
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
        filePaths = files.toArray(new String[0]);
    }

    private BufferedReader initReader(String s)
        throws IOException
    {
        File file = new File(s);
        InputStreamReader isr = null;
        if (isGZip(file)) {
            isr = initGZipStream(file);
        }
        else if (isBZip2(file)) {
            isr = initBZip2(file);
        }
        else {
            isr = initNormalStream(file);
        }
        return new BufferedReader(isr);
    }

    private InputStreamReader initBZip2(File file)
        throws UnsupportedEncodingException, FileNotFoundException, IOException
    {
        return new InputStreamReader(new BZip2CompressorInputStream(new FileInputStream(file)),
                encoding);
    }

    private boolean isBZip2(File file)
    {
        return file.getAbsolutePath().endsWith(".bz2");
    }

    private boolean isGZip(File file)
    {
        return file.getAbsolutePath().endsWith(".gz");
    }

    private InputStreamReader initNormalStream(File file)
        throws UnsupportedEncodingException, FileNotFoundException
    {
        return new InputStreamReader(new FileInputStream(file), encoding);
    }

    private InputStreamReader initGZipStream(File file)
        throws UnsupportedEncodingException, FileNotFoundException, IOException
    {
        return new InputStreamReader(new GZIPInputStream(new FileInputStream(file)), encoding);
    }

    public boolean hasNext()
        throws IOException, CollectionException
    {
        BufferedReader reader = getReader(currentReaderIdx);
        while (dataRemains(reader) && !isMatch(nextLine))
            ;

        if (nextLine == null) {
            return takeNextReader();
        }
        return true;
    }

    private BufferedReader getReader(int idx)
        throws IOException
    {
        if (reader == null) {
            reader = initReader(filePaths[idx]);
        }

        return reader;
    }

    private boolean dataRemains(BufferedReader reader)
    {
        boolean stillDataToRead = false;

        try {
            stillDataToRead = (nextLine = reader.readLine()) != null;
        }
        catch (IOException e) {
            nextLine = null;
            stillDataToRead = false;
        }

        return stillDataToRead;
    }

    private boolean takeNextReader()
        throws IOException, CollectionException
    {
        reader.close();
        reader = null;
        filePaths[currentReaderIdx] = null;

        currentReaderIdx++;

        if (currentReaderIdx == filePaths.length) {
            return false;
        }

        return hasNext();
    }

    private boolean isMatch(String nextLine)
    {
        return !nextLine.isEmpty() && containsValidFields(nextLine);
    }

    private boolean containsValidFields(String nextLine)
    {
        // we test for a 'text'-information and the 'created_at' information if we find both we
        // conclude that a line is an actual twitter message
        return nextLine.contains(CREATE_MARKER) && nextLine.contains(TEXT_MARKER);
    }

    public Progress[] getProgress()
    {
        return null;
    }

    @Override
    public void getNext(JCas jCas)
        throws IOException, CollectionException
    {
        // annotate raw-tweet in an own type we 
        RawTweet raw = new RawTweet(jCas);
        raw.setRawTweet(nextLine);
        raw.addToIndexes();

        // set payload as the document text
        String extract = getExtract(nextLine, TEXT_MARKER, MARKER_END);

        //unescaping makes the unicode characters (\\uXXXX) readable
        jCas.setDocumentText(StringEscapeUtils.unescapeJava(extract));
        jCas.setDocumentLanguage("x-unspecified");
        
        //
        //Get DCT for further processing of HeidelTime
        //
        setDCT(jCas);
        
        
    }
    
    
    //
    //Extracts the DCT from the RawTweet and converts it into the right format, which is needed by HeidelTime
    //
    public void setDCT(JCas jcas){
    	String rawTweet = getRawTweet(jcas);
    	boolean ctime = rawTweet.contains("created_at\":");
        String creationTime = "";
        if (ctime){
        	creationTime = rawTweet.split("created_at\":")[1];
        	if(creationTime.contains(",\"")){
        	creationTime = creationTime.split(",\"")[0];
        	}
        }
        
        String id = rawTweet.split("id\":")[1];
        
        String time_value;
		//String date_value;
		
		String month = normMonth(creationTime.split(" ")[1]);
		String day = creationTime.split(" ")[2];
		String year = creationTime.split(" ")[5];
		year = year.split("\"")[0];
		String time = creationTime.split(" ")[3];
        time_value = year + "-" + month + "-" + day + "T0" + time;
        //date_value = year + "-" + month + "-" + day;
        
        Dct dct = new Dct(jcas);
        dct.setBegin(0);
        dct.setEnd(1);
        dct.setFilename("TweetID: " +id);
        dct.setTimexId("dct");
        dct.setValue(time_value);
        dct.addToIndexes();
    }

    

	static String getExtract(String rawText, final String START, final String END)
    {
        int idxStart = rawText.indexOf(START);
        int idxEnd = rawText.indexOf(END, idxStart + START.length());

        if (idxStart < 0 || idxEnd < 0) {
            logWarn("Extraction of begin: [" + START + "] end: [" + END + "] failed in raw: ["
                    + rawText + "]");
            return "";
        }

        String extract = rawText.substring(idxStart + START.length(), idxEnd);
        return extract;
    }
	
	private String getRawTweet(JCas aJCas)
    {
        // Note: The raw type contains the tweet in the JSON format with all information Twitter
        // provides. Look into the Twitter API description to find details of what information is
        // basically provided. Be aware that not every information is set in every message.
        // Furthermore, the data contain a random mix of languages. You have to find a ways how to
        // recognize the languages you want to use for your project!

        RawTweet raw = JCasUtil.selectSingle(aJCas, RawTweet.class);
        String rawTweet = raw.getRawTweet();
        return rawTweet;
    }
	
	public String normMonth(String month){
		if (month.toLowerCase().startsWith("jan")){
			month = "01";
		}
		else if (month.toLowerCase().startsWith("feb")){
			month = "02";
		}
		else if (month.toLowerCase().startsWith("mar")){
			month = "03";
		}
		else if (month.toLowerCase().startsWith("apr")){
			month = "04";
		}
		else if (month.toLowerCase().startsWith("may")){
			month = "05";
		}
		else if (month.toLowerCase().startsWith("jun")){
			month = "06";
		}
		else if (month.toLowerCase().startsWith("jul")){
			month = "07";
		}
		else if (month.toLowerCase().startsWith("aug")){
			month = "08";
		}
		else if (month.toLowerCase().startsWith("sep")){
			month = "09";
		}
		else if (month.toLowerCase().startsWith("oct")){
			month = "10";
		}
		else if (month.toLowerCase().startsWith("nov")){
			month = "11";
		}
		else if (month.toLowerCase().startsWith("dec")){
			month = "12";
		}
		return month;
	}

    private static void logWarn(String message)
    {
        Logger.getLogger(TwitterReader.class.getName()).warning(message);
    }


}
