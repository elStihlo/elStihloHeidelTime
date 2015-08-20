package Pipeline;

import java.util.Collection;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unihd.dbs.uima.types.heideltime.Dct;
import de.unihd.dbs.uima.types.heideltime.Timex3;

public class TwitterWriter extends JCasAnnotator_ImplBase{

	
	private int numberOfDocuments = 0;
	
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		numberOfDocuments++;
		String rawTweet = aJCas.getDocumentText();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Message: " + rawTweet);
		
		Collection<Dct> dct = JCasUtil.select(aJCas, Dct.class );
		for (Dct dCT : dct){
			System.out.println("DCTValue: " + dCT.getValue());
		}
		
		Collection<Timex3> timex = JCasUtil.select(aJCas, Timex3.class);
		for (Timex3 timex3 : timex){
			System.out.println(" Timex3 Value: " + timex3.getTimexValue());
			System.out.println(" Timex3Text: " + timex3.getCoveredText());
		}
		
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//printTimexAnnotationsInline(aJCas);
	}
	
	
	/*public void printTimexAnnotationsInline(JCas jcas){
		
		
		// what has to be printed?
	    String toprint = "";
		
		
		// document text
	    String doctext    = jcas.getDocumentText();
	    int startposition = 0;
	    int endposition   = doctext.length();
	    boolean anyTimex  = false;
	    
		// get timex index
		FSIndex indexTimex   = jcas.getAnnotationIndex(Timex3.type);
		FSIterator iterTimex = indexTimex.iterator();
		
		
		while (iterTimex.hasNext()){
			anyTimex = true;
			Timex3 t = (Timex3) iterTimex.next();
			endposition = t.getBegin();
			if (endposition < startposition){
				if (printDetails == true){
					System.err.println("[TwitterWriter] Overlapping expressions... ignoring: "+t.getCoveredText());
				}
			}
		}	
		
		
		if (anyTimex == true){
            // text from last timex to end
			toprint = toprint + doctext.substring(startposition);
		}
		if (anyTimex == false){
			// whole document text
			toprint = toprint + doctext;
		}
		
		System.out.println("Das ist was rauskommt: " + toprint);
			
	}*/
	
	
	public void collectionProcessComplete()
	        throws AnalysisEngineProcessException
	    {
	        super.collectionProcessComplete();
	        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	        System.out.println("Number of Tweets: "  + numberOfDocuments);
	        System.out.println("Writer hat auch was gemacht!!!");
	        
	        
	    }

}
