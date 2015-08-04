package Pipeline;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.unihd.dbs.uima.reader.aceternreader.ACETernReader;
//import de.unihd.dbs.uima.reader.tempeval2reader.Tempeval2Reader;
//import de.unihd.dbs.uima.reader.tempeval3reader.Tempeval3Reader;

public class Pipeline {

	public static void main(String args[]) throws Exception{
		
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                ACETernReader.class, ACETernReader.PARAM_INPUTDIR, "Test/Timebank");
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Tempeval2Reader.class, Tempeval2Reader.PARAM_INPUTDIR, "Test/Timebank");
		*/
		
		/*CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Tempeval3Reader.class, Tempeval3Reader.PARAM_INPUTDIR, "Test/Tempeval3");*/
		
		
		SimplePipeline.runPipeline(reader);
	}
	
	
	
}
