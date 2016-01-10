package ie.gmit.sw.frequencyAnalyzor;

import java.util.Map;

public interface FrequencyAnalyzer {
	/**
	 * 
	 * @param Word key for a map.
	 */
	public abstract void put(String Word);

	public abstract Map<String, Integer> getWordMap();
}
