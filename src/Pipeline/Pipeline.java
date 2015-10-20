package Pipeline;


import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.unihd.dbs.uima.annotator.heideltime.HeidelTime;
import de.unihd.dbs.uima.annotator.treetagger.TreeTaggerWrapper;

/**
 * Pipeline to annotate german Twitter Data 
 * @author Christian Aldenhoff
 */
public class Pipeline {


	public static void main(String args[]) throws Exception{
		
		
		//
		// Reader for TwitterData as Input
		//
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                BA_TwitterReader.class, BA_TwitterReader.PARAM_INPUTDIR, "Test/TwitterData",
                BA_TwitterReader.PARAM_DCT, true);
		//
		// Reader for Timebank corpus as Input
		//
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                BA_TwitterReader.class, BA_TwitterReader.PARAM_INPUTDIR, "Test/Timebank", BA_TwitterReader.PARAM_DCT, true);*/

		//
		// TreeTaggerWrapper for Preprocessing
		// If using TreeTagger for Timebank corpus set
		// PARAM_LANGUAGE, "english"
		// PARAM_IMPROVE_GERMAN_SENTENCES, false
		//
		AnalysisEngineDescription treeTagger = AnalysisEngineFactory
	                .createEngineDescription(TreeTaggerWrapper.class, TreeTaggerWrapper.PARAM_ANNOTATE_PARTOFSPEECH, true,
	                		TreeTaggerWrapper.PARAM_LANGUAGE, "german", TreeTaggerWrapper.PARAM_ANNOTATE_TOKENS, true,
	                		TreeTaggerWrapper.PARAM_ANNOTATE_SENTENCES, true, TreeTaggerWrapper.PARAM_IMPROVE_GERMAN_SENTENCES, true);

		//
		// HeidelTime-Annotator for annotating temporal Expressions
		//
		String Date = "Date";
		String Time= "Time";
		String Set= "Set";
		String Duration= "Duration";
		String Debugging= "Debugging";
		String ConvertDurations= "ConvertDurations";
		String Type= "Type";
		String Language = "Language";
		//
		// If using the Timebank corpus as Input, set 
		// Language, "english"
	    // Type, "news"
		//
		AnalysisEngineDescription heidelTime = AnalysisEngineFactory
	                .createEngineDescription(HeidelTime.class, Language, "germancoll", Date, true, Time, true, Set, true, Duration, true, Debugging, true,
	                		ConvertDurations, true, Type, "colloquial");
		 
		 AnalysisEngineDescription writer = AnalysisEngineFactory
				 .createEngineDescription(BA_Writer.class);

		 
		SimplePipeline.runPipeline(reader, treeTagger, heidelTime, writer);

		
	}
	
	
	
}
