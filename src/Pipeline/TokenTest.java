package Pipeline;

import java.util.Collection;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;




public class TokenTest
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        System.out.println("Document is: " + jcas.getDocumentText());
        
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");
        
        int nr = 0;
        
        Collection<Sentence> sentence = JCasUtil.select(jcas, Sentence.class);
        for (Sentence satz : sentence){
        	nr++;
        System.out.println("Satz " + nr + " " + satz );
        
        }
       
      
    }
    public void collectionProcessComplete()
	        throws AnalysisEngineProcessException
	    {
	        super.collectionProcessComplete();
	        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	        System.out.println("ICH HABE ETWAS GETAN!!!");
	        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	        
	    }
}