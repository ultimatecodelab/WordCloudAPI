package ie.gmit.sw.parser;

import ie.gmit.sw.frequencyAnalyzor.ComputeFrequency;

public class ParserFactory {
	/**
	 * This Factory returns the appropriate class in runtime determined by
	 * the parse type specified parse type (Enum).
	 * @param type parseType (enum)
	 * @return returns Parsable object (UrlParser or FileParser object in
	 *         runtime)
	 */
	// choosing one instance in runtime
	public static Parsable getParser(ParseType type) {
		if (type == ParseType.FileParser) {
			return new FileParser(new ComputeFrequency()); // dependency
															// FrequencyAnalyzer(interface)
		} // file parser
		else {
			return new URLParser(new ComputeFrequency());// dependency
															// FrequencyAnalyzer(interface)
		} // url parser

	}
}
