package ie.gmit.sw.randomStrategy;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class WordCloudStrategy implements WordCloudRandomiser {

	private int fontSize = 0;
	private int minFont = 10;

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
				new Font(Font.MONOSPACED, Font.ITALIC, fontSize), new Font(Font.DIALOG, Font.BOLD, fontSize),
				new Font(Font.SANS_SERIF, Font.ITALIC, fontSize), new Font(Font.DIALOG, Font.BOLD, fontSize),
				new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, fontSize), new Font(Font.DIALOG, Font.PLAIN, fontSize),
				new Font(Font.MONOSPACED, Font.PLAIN, fontSize), new Font(Font.SANS_SERIF, Font.PLAIN, fontSize),
				new Font(Font.DIALOG, Font.HANGING_BASELINE, fontSize) };

		return font[rand.nextInt(font.length - 1)];
	}

	private Color[] colours = { Color.red, Color.cyan, Color.yellow, Color.green, Color.magenta, Color.DARK_GRAY,
			Color.pink };

	@Override
	public Font getRandomFont(int frequncyofWord) {
		Font f = getFont(frequncyofWord);
		return f;

	}

	@Override
	public Color getRandomColor() {
		Random rand = new Random();
		return colours[rand.nextInt(colours.length - 1)];
	}

}
