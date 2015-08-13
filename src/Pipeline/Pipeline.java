package Pipeline;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;


//import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unihd.dbs.uima.annotator.heideltime.HeidelTime;
import de.unihd.dbs.uima.annotator.treetagger.TreeTaggerWrapper;
import de.unihd.dbs.uima.reader.aceternreader.ACETernReader;


public class Pipeline {

	public static void main(String args[]) throws Exception{
		
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                ACETernReader.class, ACETernReader.PARAM_INPUTDIR, "Test/TimebankOnly4", ACETernReader.PARAM_DCT, true);
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Tempeval2Reader.class, Tempeval2Reader.PARAM_INPUTDIR, "Test/Timebank");
		*/
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Tempeval3Reader.class, Tempeval3Reader.PARAM_INPUTDIR, "Test/Tempeval3");*/
		
		 /*AnalysisEngineDescription segmenter = AnalysisEngineFactory
	                .createEngineDescription(BreakIteratorSegmenter.class);*/
		 
		 AnalysisEngineDescription treeTagger = AnalysisEngineFactory
	                .createEngineDescription(TreeTaggerWrapper.class, TreeTaggerWrapper.PARAM_ANNOTATE_PARTOFSPEECH, true,
	                		TreeTaggerWrapper.PARAM_LANGUAGE, "english", TreeTaggerWrapper.PARAM_ANNOTATE_TOKENS, true,
	                		TreeTaggerWrapper.PARAM_ANNOTATE_SENTENCES, true, TreeTaggerWrapper.PARAM_IMPROVE_GERMAN_SENTENCES, false);
		 
		 AnalysisEngineDescription heidelTime = AnalysisEngineFactory
	                .createEngineDescription(HeidelTime.class, HeidelTime.PARAM_LANGUAGE, "english", HeidelTime.PARAM_DATE, true,
	                		HeidelTime.PARAM_DURATION, true, HeidelTime.PARAM_SET, true, HeidelTime.PARAM_TIME, true,
	                		HeidelTime.PARAM_TYPE_TO_PROCESS, "narratives");
		 
		 
		
		
		SimplePipeline.runPipeline(reader, treeTagger, heidelTime);
		
		
		
		
	}
	
	
	
}
