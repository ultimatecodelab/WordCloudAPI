package ie.gmit.sw.parser;

import ie.gmit.sw.frequencyAnalyzor.ComputeFrequency;

public class ParserFactory {

	public static Parsable getParser(ParseType type) {
		if (type == ParseType.FileParser) {
			return new FileParser(new ComputeFrequency());
		} // file parser
		else {
			return new URLParser(new ComputeFrequency());
		} // url parser

	}
}
