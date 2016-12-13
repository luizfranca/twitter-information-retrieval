package index;

import java.util.ArrayList;
import java.util.Map;

import data.Post;
import data.Tweet;
import persistence.xml.XMLPersistence;

public class TestIndexer {

	public static void main(String[] args) throws Exception {

		
		
		ArrayList<Tweet> corpus = XMLPersistence.readTweet("tweetsEN20.xml");
		Indexer indexer = new Indexer(corpus);
//		Map<String, ArrayList<Post>> indexes = XMLPersistence.readIndexes("Indexes.xml");
//		indexer.setIndexes(indexes);
		
		indexer.generateIndex(corpus);

//		System.out.println(indexer.vocabulary.getTerms().get("upload"));
	
//		System.out.println(indexer.getIndexes().get("upload").get(0).getTf_idf());
//		System.out.println(indexer.getIndexes().get("upload").get(0).getDocID());
		System.out.println("Size: " + indexer.getIndexes().size());
		XMLPersistence.saveIndex(indexer.getIndexes(), "Indexes20.xml");
	}

}
