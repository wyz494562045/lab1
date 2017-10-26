package final_count;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class counterTest {
    private static counter countertest=new counter();
    private static String text="to explore strange new worlds to seek out new life and new civilizations and good civilizations and fine civilizations";
    
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	 public void tearDown() throws Exception {
	 }
	
	@Test
	public void testQueryBridgeWordsCase1() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="seek";
		String word2="to";
		String result="No bridge words from \"seek\" to \"to\"!";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase2() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="explore";
		String word2="new";
		String result="The bridge words from \"explore\" to \"new\" is: strange.";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase3() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="and";
		String word2="civilizations";
		String result="The bridge words from \"and\" to \"civilizations\" are: new, good and fine.\"";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase4() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="";
		String word2="";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}
	
	@Test
	public void testQueryBridgeWordsCase5() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="seek";
		String word2="";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase6() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="to explore new";
		String word2="seek";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase7() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="find out seek";
		String word2="valid information ab";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase8() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="";
		String word2="fine explore new";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase9() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="abc";
		String word2="123provide";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase10() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="%^wor^ld";
		String word2="t*o";
		String result="Invalid input!(blank or include illegal character)";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase11() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="happiness";
		String word2="out";
		String result="No "+"\""+"happiness"+"\""+" in the graph!";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase12() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="seek";
		String word2="incredible";
		String result="No "+"\""+"incredible"+"\""+" in the graph!";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

	@Test
	public void testQueryBridgeWordsCase13() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="Chinese";
		String word2="English";
		String result="No "+"\""+"Chinese"+"\""+" or "+"\""+"English"+"\""+" in the graph!";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}
	
	@Test
	public void testQueryBridgeWordsCase14() {
		countertest.SetValidInf(text);
		countertest.CreateDirectedGraph();
		String word1="StranGe";
		String word2="Worlds";
		String result="The bridge words from \"StranGe\" to \"Worlds\" is: new.";
		assertEquals(result,countertest.queryBridgeWords(word1,word2));
	}

}


