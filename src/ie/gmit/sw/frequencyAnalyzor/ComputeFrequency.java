package ie.gmit.sw.frequencyAnalyzor;

import java.util.HashMap;
import java.util.Map;

public class ComputeFrequency implements FrequencyAnalyzer {
	//holds words  and frequencies
	private Map<String, Integer> wordsAndFreq = new HashMap<>();

	public ComputeFrequency() {
		wordsAndFreq.clear(); //clearing initially
	}

	@Override
	public void put(String Word) {
		if (wordsAndFreq.containsKey(Word.toString())) {

			int val = wordsAndFreq.get(Word) + 1;
			wordsAndFreq.put(Word.toString().trim(), val);
		} else {
			wordsAndFreq.put(Word, 1);
		}
	}

	@Override
	public Map<String, Integer> getWordMap() {
		// returning the copy of hashmap
		return new HashMap<>(wordsAndFreq);//returning copy
	}
}
