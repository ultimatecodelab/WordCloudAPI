package ie.gmit.sw.frequencyAnalyzor;

import java.util.Map;

public interface FrequencyAnalyzer {
	public abstract void put(String Word);

	public abstract Map<String, Integer> getWordMap();
}
