package Pipeline;


import org.apache.uima.analysis_engine.AnalysisEngineDescription;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.core.treetagger.TreeTaggerPosTagger;
import de.tudarmstadt.ukp.dkpro.core.arktools.ArktweetTokenizer;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
import de.unihd.dbs.uima.annotator.annotationtranslator.AnnotationTranslator;
import de.unihd.dbs.uima.annotator.heideltime.HeidelTime;
import de.unihd.dbs.uima.annotator.treetagger.TreeTaggerWrapper;
import de.unihd.dbs.uima.consumer.aceternwriter.ACETernWriter;
import de.unihd.dbs.uima.reader.aceternreader.ACETernReader;
import de.unihd.dbs.uima.reader.tempeval3reader.Tempeval3Reader;


public class Pipeline {

	public static void main(String args[]) throws Exception{
		
		//String inputFolder = "Test/TwitterData";
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                BA_TwitterReader.class, BA_TwitterReader.PARAM_INPUTDIR, "F:/Uni/BachelorArbeit/TweetsMitTimeX/Sample4",
                BA_TwitterReader.PARAM_DCT, true);*/
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                BA_TwitterReader.class, BA_TwitterReader.PARAM_INPUTDIR, "F:/Uni/BachelorArbeit/TweetsMitTimeX/TrainingTweets/NochNichtGefunden",
                BA_TwitterReader.PARAM_DCT, true);*/
		
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                BA_TwitterReader.class, BA_TwitterReader.PARAM_INPUTDIR, "F:/Uni/BachelorArbeit/TweetsMitTimeX/EinzelTweets",
                BA_TwitterReader.PARAM_DCT, true);
		
			
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                BA_TwitterReader.class, BA_TwitterReader.PARAM_INPUTDIR, "Test/Timebank", BA_TwitterReader.PARAM_DCT, true);*/
		
				
		 /*AnalysisEngineDescription translator = AnalysisEngineFactory
				 .createEngineDescription(AnnotationTranslator.class, 
						 AnnotationTranslator.PARAM_DKPRO_TO_HEIDELTIME, false, 
						 AnnotationTranslator.PARAM_HEIDELTIME_TO_DKPRO, true);*/
		 
		 
		 
		 AnalysisEngineDescription treeTagger = AnalysisEngineFactory
	                .createEngineDescription(TreeTaggerWrapper.class, TreeTaggerWrapper.PARAM_ANNOTATE_PARTOFSPEECH, true,
	                		TreeTaggerWrapper.PARAM_LANGUAGE, "german", TreeTaggerWrapper.PARAM_ANNOTATE_TOKENS, true,
	                		TreeTaggerWrapper.PARAM_ANNOTATE_SENTENCES, true, TreeTaggerWrapper.PARAM_IMPROVE_GERMAN_SENTENCES, true);
		 
		 /*AnalysisEngineDescription treeTagger = AnalysisEngineFactory
	                .createEngineDescription(TreeTaggerWrapper.class, TreeTaggerWrapper.PARAM_ANNOTATE_PARTOFSPEECH, true,
	                		TreeTaggerWrapper.PARAM_LANGUAGE, "english", TreeTaggerWrapper.PARAM_ANNOTATE_TOKENS, true,
	                		TreeTaggerWrapper.PARAM_ANNOTATE_SENTENCES, true, TreeTaggerWrapper.PARAM_IMPROVE_GERMAN_SENTENCES, false);*/
		 
		 /*AnalysisEngineDescription heidelTime = AnalysisEngineFactory
	                .createEngineDescription(HeidelTime.class, HeidelTime.PARAM_LANGUAGE, "english", HeidelTime.PARAM_DATE, true,
	                		HeidelTime.PARAM_DURATION, true, HeidelTime.PARAM_SET, true, HeidelTime.PARAM_TIME, true,
	                		HeidelTime.PARAM_TYPE_TO_PROCESS, "news", HeidelTime.PARAM_DEBUG, true, HeidelTime.PARAM_GROUP, true);*/
		 
		 
		 
		 
		 AnalysisEngineDescription heidelTime = AnalysisEngineFactory
	                .createEngineDescription(HeidelTime.class, HeidelTime.PARAM_LANGUAGE, "germancoll", HeidelTime.PARAM_DATE, true,
	                		HeidelTime.PARAM_DURATION, true, HeidelTime.PARAM_SET, true, HeidelTime.PARAM_TIME, true,
	                		HeidelTime.PARAM_TYPE_TO_PROCESS, "colloquial", HeidelTime.PARAM_DEBUG, true, HeidelTime.PARAM_GROUP, true);
		 
		 AnalysisEngineDescription writer = AnalysisEngineFactory
				 .createEngineDescription(BA_Writer.class);
		 
		 		
		
		//SimplePipeline.runPipeline(reader, writer);
		SimplePipeline.runPipeline(reader, treeTagger, heidelTime, writer);
		 //SimplePipeline.runPipeline(reader, segmenter, translator);
		//SimplePipeline.runPipeline(reader, tokenizer, tokenTest);
		
		
		
	}
	
	
	
}
