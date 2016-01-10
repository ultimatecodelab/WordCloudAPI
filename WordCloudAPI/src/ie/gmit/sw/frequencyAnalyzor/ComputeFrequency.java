package ie.gmit.sw.frequencyAnalyzor;

import java.util.HashMap;
import java.util.Map;

/**
 * ComputeFrequency implements {@link FrequencyAnalyzer}. This class is
 * responsible for analyzing the frequency of the words.
 * 
 * @author Arjun Kharel
 *
 */
public class ComputeFrequency implements FrequencyAnalyzer {
	// holds words and frequencies
	private Map<String, Integer> wordsAndFreq = new HashMap<>();

	public ComputeFrequency() {
		wordsAndFreq.clear(); // clearing initially
	}

	public void put(String Word) {
		if (wordsAndFreq.containsKey(Word.toString())) {

			int val = wordsAndFreq.get(Word) + 1;
			wordsAndFreq.put(Word.toString().trim(), val);
		} else {
			wordsAndFreq.put(Word, 1);
		}
	}

	/**
	 * @return returns the map containing the words and frequencies.
	 */
	public Map<String, Integer> getWordMap() {
		// returning the copy of hashmap
		return new HashMap<>(wordsAndFreq);// returning copy
	}
}
