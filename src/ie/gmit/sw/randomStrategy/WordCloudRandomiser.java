package ie.gmit.sw.randomStrategy;

import java.awt.Color;
import java.awt.Font;

public interface WordCloudRandomiser {

	public abstract Font getRandomFont(int frequencyofWord);

	public abstract Color getRandomColor();
}
