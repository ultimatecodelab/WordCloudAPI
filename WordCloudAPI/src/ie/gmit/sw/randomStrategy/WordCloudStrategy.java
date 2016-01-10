package ie.gmit.sw.randomStrategy;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

/**
 * {@link WordCloudStrategy} implements {@link WordCloudRandomiser}. This class
 * is responsible for returning the font proportional to the frequency of the
 * word. This class also returns the random color.
 * 
 * @author Arjun Kharel
 *
 */
public class WordCloudStrategy implements WordCloudRandomiser {

	private int fontSize = 0;
	private int minFont = 10;

	/*
	 * Returning the Font by randomly selecting, but we are using the frequency
	 * of the word to return the the font size... the word with bigger frequency
	 * gets the bigger font
	 */
	public Font getFont(int wordFreq) {
		Random rand = new Random();
		fontSize = 0;

		if (wordFreq == 1) {
			fontSize += minFont + 5;
		} else if (wordFreq >= 2 && wordFreq < 4) {
			fontSize += rand.nextInt((25 - 5) + 1) + 10;
		} else if (wordFreq >= 4 && wordFreq < 6) {
			fontSize += (int) ((minFont * 2.5) + minFont);
		} else if (wordFreq >= 6 && wordFreq <= 8) {
			fontSize += (int) ((minFont * 4) + minFont);
		} else if (wordFreq >= 9) {
			fontSize += (int) ((minFont * 4.8) + minFont);
		}
		Font[] font = { new Font(Font.SANS_SERIF, Font.PLAIN, fontSize),
				new Font(Font.MONOSPACED, Font.PLAIN, fontSize), new Font(Font.DIALOG, Font.BOLD, fontSize),
				new Font(Font.SANS_SERIF, Font.PLAIN, fontSize), new Font(Font.DIALOG, Font.BOLD, fontSize),
				new Font(Font.SANS_SERIF, Font.PLAIN, fontSize), new Font(Font.DIALOG, Font.PLAIN, fontSize),
				new Font(Font.MONOSPACED, Font.PLAIN, fontSize), new Font(Font.SANS_SERIF, Font.PLAIN, fontSize),
				new Font(Font.DIALOG, Font.PLAIN, fontSize) };

		return font[rand.nextInt(font.length - 1)];
	}

	// Colours
	private Color[] colours = { Color.red, Color.cyan, Color.yellow, Color.green, Color.magenta, Color.DARK_GRAY,
			Color.pink };

	// returning font
	public Font getRandomFont(int frequncyofWord) {
		Font f = getFont(frequncyofWord);
		return f;

	}

	// returning randomColor
	public Color getRandomColor() {
		Random rand = new Random();
		return colours[rand.nextInt(colours.length - 1)];
	}

}
