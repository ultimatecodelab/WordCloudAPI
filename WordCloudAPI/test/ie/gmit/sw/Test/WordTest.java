package ie.gmit.sw.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ie.gmit.sw.wordcloud.Word;

public class WordTest {

	@Test
	public void equals() {
		assertEquals(new Word("arjun"), new Word("Arjun")); // test passed
		assertFalse(new Word("Java").equals(new Word("Software"))); // test
	}

}
