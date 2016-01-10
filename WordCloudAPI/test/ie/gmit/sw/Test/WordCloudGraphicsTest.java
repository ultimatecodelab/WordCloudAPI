package ie.gmit.sw.Test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;

import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.paint.Graphicator;
import ie.gmit.sw.paint.WordCloudGraphics;

public class WordCloudGraphicsTest {
	private Graphicator graphics = new WordCloudGraphics();
	@Before
	public void setUp() throws Exception {
		//initialization first
		graphics.setColor(Color.red);
		graphics.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 40));
		graphics.drawWord("JUnitTestCase", 400, 250);
	}

	@Test
	public void test() throws Exception {
		boolean status = graphics.generatePNGGraphics("TestWordcloud.png");
		assertTrue(status); //assertTrue(status) // test passed...
	}

}
