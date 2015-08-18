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
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import TwitterReader.type.RawTweet;
import de.tudarmstadt.ukp.dkpro.core.api.io.JCasResourceCollectionReader_ImplBase;



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

    private static void logWarn(String message)
    {
        Logger.getLogger(TwitterReader.class.getName()).warning(message);
    }


}
