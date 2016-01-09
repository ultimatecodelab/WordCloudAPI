package ie.gmit.sw.Test;

import static org.junit.Assert.*;

import java.awt.Font;

import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.randomStrategy.WordCloudRandomiser;
import ie.gmit.sw.randomStrategy.WordCloudStrategy;

public class WordCloudStrategyTest {

	WordCloudRandomiser wordCloudStrategy;

	@Before
	public void setUp() throws Exception {
		wordCloudStrategy = new WordCloudStrategy();
	}

	@Test
	public void test() {
		int tempFreq = 10;
		Font font = wordCloudStrategy.getRandomFont(tempFreq);
		assertTrue(font.getSize() > 50);

		tempFreq = 3;
		font = wordCloudStrategy.getRandomFont(tempFreq);
		assertTrue(font.getSize() > 20);
	}

}
