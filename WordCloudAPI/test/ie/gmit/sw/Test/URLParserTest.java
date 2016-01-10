package ie.gmit.sw.Test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ie.gmit.sw.frequencyAnalyzor.ComputeFrequency;
import ie.gmit.sw.parser.Parsable;
import ie.gmit.sw.parser.URLParser;

public class URLParserTest {
	@Rule
	 public final ExpectedException exception = ExpectedException.none();
	Parsable urlParser;
	@Before
	public void setUp() throws Exception {
		urlParser = new URLParser(new ComputeFrequency());
	
	}

	@Test(expected = IllegalArgumentException.class)
	public void test() throws Exception {
		urlParser.parse(null); //test passed.. expected exception returned.
	}

}
