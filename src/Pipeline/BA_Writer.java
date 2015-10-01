package Pipeline;


import java.util.Collection;


import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.ba.type.Timex3Gold;
import de.unihd.dbs.uima.types.heideltime.Dct;
import de.unihd.dbs.uima.types.heideltime.Timex3;


/**
 *  
 */

public class BA_Writer extends JCasAnnotator_ImplBase{

	
	private int numberOfDocuments = 0;
	//int count = 0;
	int correct = 0;
	int allcorrect = 0;
	int nrTimes = 0;
	int allFoundTimes = 0;
	int nrGoldTimes = 0;
	int overall = 0;
	
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		numberOfDocuments++;
		int groesse=0;
		//count++;
		String rawTweet = aJCas.getDocumentText();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("Message: " + rawTweet);
		
				
		
		/*Collection<Dct> dct = JCasUtil.select(aJCas, Dct.class );
		for (Dct dCT : dct){
			System.out.println("DCTValue: " + dCT.getValue());
		}*/
		
		Collection<Timex3Gold> gold = JCasUtil.select(aJCas, Timex3Gold.class);
		Collection<Timex3> timex = JCasUtil.select(aJCas, Timex3.class);
		
		nrTimes = 0;
		for (Timex3 timex3 : timex){
			nrTimes++;
			System.out.println(" Timex3 Value: " + timex3.getTimexValue());
			System.out.println(" Timex3Text: " + timex3.getCoveredText());
			System.out.println(" Timex3Type: " + timex3.getTimexType());
			System.out.println(" Timex3ID: " + timex3.getTimexId());			
		}
		nrGoldTimes = 0;
		for (Timex3Gold go : gold){
			nrGoldTimes++;
			System.out.println(" GoldValue: " + go.getValue());
			System.out.println(" GoldText: " + go.getTimex3Text());
			System.out.println(" GoldType: " + go.getTimex3type());
			System.out.println(" GoldID: " + go.getTID());
			System.out.println("- - - - - - - - - - - - -");
		}
		correct = 0;
		
		for (Timex3 timex3 : timex){
			for (Timex3Gold go : gold){
				int size = gold.size()-1;
				groesse = size;
				if(timex3.getTimexId().equals(go.getTID())||timex3.getCoveredText().equals(go.getTimex3Text())){
						if(timex3.getTimexValue().equals(go.getValue())){
							correct++;
							allcorrect++;
							if(correct>size){
								correct--;
								allcorrect--;
							}
						}
				}
			}
			
		}
		
		overall = overall + (nrGoldTimes-1);
		allFoundTimes = allFoundTimes + nrTimes;
		System.out.println("found: " + nrTimes);
		System.out.println("Golds: " + (nrGoldTimes-1));
		System.out.println(correct + " out of "+ (nrGoldTimes-1) + " correct");
		System.out.println("Test::: " + groesse);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
	}
	
	
	
	
	
	public void collectionProcessComplete()
	        throws AnalysisEngineProcessException
	    {
	        super.collectionProcessComplete();
	        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	        System.out.println("Number of Documents: "  + numberOfDocuments);
	        //Precision
	        double pre = (double)allcorrect/(double)allFoundTimes;
	        System.out.println("Precision: " + allcorrect + " out of " + allFoundTimes + " found Timexes are correct!!!!!!!!");
	        System.out.println((((double)allcorrect/(double)allFoundTimes)*100) + "% are correct");
	        //Recall
	        double rec = (double)allcorrect/(double)overall;
	        System.out.println("Recall: " + allcorrect + " out of " + overall + " Timexes were found and correct!!!!!!!!");
	        System.out.println((((double)allcorrect/(double)overall)*100) + "% are correct");
	        //F1 Score
	        double f1s = 2*((pre * rec)/(pre + rec));
	        System.out.println("F1-Score: " + (f1s*100) + "%");
	        System.out.println("All documents processed!!!");
	        
	        
	    }

}
