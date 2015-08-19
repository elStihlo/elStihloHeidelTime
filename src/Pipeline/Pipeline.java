package Pipeline;

import org.apache.uima.UIMAFramework;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CasConsumer;
import org.apache.uima.collection.CasConsumerDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.impl.CasConsumerFactory_impl;

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
		
		String inputFolder = "Test/TwitterData";
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                ACETernReader.class, ACETernReader.PARAM_INPUTDIR, "Test/TimebankOnly4", ACETernReader.PARAM_DCT, true);*/
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Tempeval2Reader.class, Tempeval2Reader.PARAM_INPUTDIR, "Test/Timebank");
		*/
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Tempeval3Reader.class, Tempeval3Reader.PARAM_INPUTDIR, "Test/Tempeval3");*/
		
		// Read all files with file ending *.gz, *.bz2 or *.json that are located in the inputFolder
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                TwitterReader.class, TwitterReader.PARAM_SOURCE_LOCATION, inputFolder,
                TwitterReader.PARAM_PATTERNS, new String[] { "*.gz", "*.bz2", "*.json" });
        
        AnalysisEngineDescription tokenizer = AnalysisEngineFactory
                .createEngineDescription(ArktweetTokenizer.class);
		
		 /*AnalysisEngineDescription segmenter = AnalysisEngineFactory
	                .createEngineDescription(BreakIteratorSegmenter.class);*/
		 
		 /*AnalysisEngineDescription segmenter = AnalysisEngineFactory
	                .createEngineDescription(OpenNlpSegmenter.class);*/
		 
		 AnalysisEngineDescription tokenTest = AnalysisEngineFactory
				 .createEngineDescription(TokenTest.class);
		 
		/* AnalysisEngineDescription dkProTreeTaggerPosTagger = AnalysisEngineFactory
				 .createEngineDescription(TreeTaggerPosTagger.class);*/
		 
		 /*AnalysisEngineDescription dkProOpenNlpPosTagger = AnalysisEngineFactory
		 .createEngineDescription(OpenNlpPosTagger.class);*/
		 
		 /*AnalysisEngineDescription translator = AnalysisEngineFactory
				 .createEngineDescription(AnnotationTranslator.class, 
						 AnnotationTranslator.PARAM_DKPRO_TO_HEIDELTIME, false, 
						 AnnotationTranslator.PARAM_HEIDELTIME_TO_DKPRO, true);*/
		 
		 
		 
		 AnalysisEngineDescription treeTagger = AnalysisEngineFactory
	                .createEngineDescription(TreeTaggerWrapper.class, TreeTaggerWrapper.PARAM_ANNOTATE_PARTOFSPEECH, true,
	                		TreeTaggerWrapper.PARAM_LANGUAGE, "english", TreeTaggerWrapper.PARAM_ANNOTATE_TOKENS, true,
	                		TreeTaggerWrapper.PARAM_ANNOTATE_SENTENCES, true, TreeTaggerWrapper.PARAM_IMPROVE_GERMAN_SENTENCES, false);
		 
		 AnalysisEngineDescription heidelTime = AnalysisEngineFactory
	                .createEngineDescription(HeidelTime.class, HeidelTime.PARAM_LANGUAGE, "english", HeidelTime.PARAM_DATE, true,
	                		HeidelTime.PARAM_DURATION, true, HeidelTime.PARAM_SET, true, HeidelTime.PARAM_TIME, true,
	                		HeidelTime.PARAM_TYPE_TO_PROCESS, "colloquial", HeidelTime.PARAM_DEBUG, true, HeidelTime.PARAM_GROUP, true);
		 
		 AnalysisEngineDescription writer = AnalysisEngineFactory
				 .createEngineDescription(TwitterWriter.class);
		
		
		
		SimplePipeline.runPipeline(reader, treeTagger, heidelTime, writer);
		 //SimplePipeline.runPipeline(reader, segmenter, translator);
		//SimplePipeline.runPipeline(reader, tokenizer, tokenTest);
		
		
		
	}
	
	
	
}
