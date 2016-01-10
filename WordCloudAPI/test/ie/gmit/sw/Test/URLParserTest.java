package ie.gmit.sw.Test;

import org.junit.Before;
import static org.junit.Assert.*;

import org.junit.Test;
import ie.gmit.sw.frequencyAnalyzor.ComputeFrequency;
import ie.gmit.sw.parser.Parsable;
import ie.gmit.sw.parser.URLParser;

public class URLParserTest {

	Parsable urlParser;
	String url;

	@Before
	public void setUp() throws Exception {
		urlParser = new URLParser(new ComputeFrequency());
		url = "http://www.rte.ie/news/2016/0110/758998-limerick-body-court/";

	}
	@Test
	public void test() throws Exception {
		boolean status = urlParser.parse(url); //test passed..
		assertTrue(status);
		
	}

}
