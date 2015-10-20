package heideltime;

import static org.junit.Assert.*;

import java.util.Collection;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unihd.dbs.uima.annotator.heideltime.HeidelTime;
import de.unihd.dbs.uima.annotator.treetagger.TreeTaggerWrapper;
import de.unihd.dbs.uima.types.heideltime.Sentence;
import de.unihd.dbs.uima.types.heideltime.Timex3;
import de.unihd.dbs.uima.types.heideltime.Token;
import Pipeline.BA_TwitterReader;

public class TestHeidelTime {

	@Test
	public void testHeidelTime() throws UIMAException{
		
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
				BA_TwitterReader.class, 
				BA_TwitterReader.PARAM_INPUTDIR, "Test/FolderForUTests",
                BA_TwitterReader.PARAM_DCT, true);
		
		for (JCas jcas : new JCasIterable(reader)){
			AnalysisEngineDescription treetagger = AnalysisEngineFactory.createEngineDescription(TreeTaggerWrapper.class,
					TreeTaggerWrapper.PARAM_ANNOTATE_PARTOFSPEECH, true,
            		TreeTaggerWrapper.PARAM_LANGUAGE, "german", TreeTaggerWrapper.PARAM_ANNOTATE_TOKENS, true,
            		TreeTaggerWrapper.PARAM_ANNOTATE_SENTENCES, true, TreeTaggerWrapper.PARAM_IMPROVE_GERMAN_SENTENCES, true);
			AnalysisEngine tagEngine = AnalysisEngineFactory.createEngine(treetagger);
			tagEngine.process(jcas);
			
			
			/*AnalysisEngineDescription heidelTime = AnalysisEngineFactory
	                .createEngineDescription(HeidelTime.class, HeidelTime.PARAM_LANGUAGE, "germancoll", HeidelTime.PARAM_DATE, true,
	                		HeidelTime.PARAM_DURATION, true, HeidelTime.PARAM_SET, true, HeidelTime.PARAM_TIME, true,
	                		HeidelTime.PARAM_TYPE_TO_PROCESS, "colloquial", HeidelTime.PARAM_DEBUG, true, HeidelTime.PARAM_GROUP, true);
			AnalysisEngine hTEngine = AnalysisEngineFactory.createEngine(heidelTime);
			hTEngine.process(jcas);*/
			
			Timex3 t = JCasUtil.selectSingle(jcas, Timex3.class);
			Collection<Token> s = JCasUtil.select(jcas, Token.class);
			for(Token to : s){
				System.out.println(to.getCoveredText() + to.getPos());
			}
			assertEquals("28.02.2015", t.getCoveredText());
			assertEquals("2015-02-28", t.getTimexValue());
			assertEquals("DATE", t.getTimexType());
			
		}
		
		
		
	}

}
