package ie.gmit.sw.wordcloudtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.frequencyAnalyzor.ComputeFrequency;
import ie.gmit.sw.frequencyAnalyzor.FrequencyAnalyzer;

public class FrequencyAnalyzorTest {
	private FrequencyAnalyzer freqAnalysis;
	private int initialSizeofMap = 0;
	@Before
	public void setUp() throws Exception {
		freqAnalysis = new ComputeFrequency();
		initialSizeofMap = freqAnalysis.getWordMap().size();
		
		freqAnalysis.put("Arjun");
		freqAnalysis.put("Arjun");
		freqAnalysis.put("Arjun");
		freqAnalysis.put("Java");
		freqAnalysis.put("Java");
		freqAnalysis.put("project");

	}

	@Test
	public void test() {

		int freqOfArjun = freqAnalysis.getWordMap().get("Arjun");
		assertEquals(3, freqOfArjun); // test passed
		
		/*the bellow test will fail because the frequency of word java is 2 setUp()
		int freqOfJava = freqAnalysis.getWordMap().get("Java");
		assertEquals(3, freqOfJava); // test passed
		*/
		
		assertTrue(freqAnalysis.getWordMap().size()>initialSizeofMap);
	}

}
