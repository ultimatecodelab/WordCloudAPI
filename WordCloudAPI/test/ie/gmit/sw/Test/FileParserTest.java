package ie.gmit.sw.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import ie.gmit.sw.frequencyAnalyzor.ComputeFrequency;
import ie.gmit.sw.parser.FileParser;
import ie.gmit.sw.parser.Parsable;

public class FileParserTest {
	private Parsable fileParser;
	// we can use this to catch the expected exception... pass in the invalid
	// file name and try
	
	@Before
	public void setUp() throws Exception {
		fileParser = new FileParser(new ComputeFrequency());
		// fileParser.parse("fkjdsjfdl.txt");
		fileParser.parse("myFile.txt");
	}

	@Test
	public void test() {
		//size of list
		int count = fileParser.listOfParsedWords().size();
		int min = 0;
		// exception.expect(Exception.class); // returns true
		assertTrue(count > min); // passed
	}

	@After
	public void tearDown() throws Exception {
		fileParser.listOfParsedWords().clear();
		System.out.println("cleared");
	}

}
