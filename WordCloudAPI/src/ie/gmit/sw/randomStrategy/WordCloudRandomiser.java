package ie.gmit.sw.randomStrategy;

import java.awt.Color;
import java.awt.Font;

public interface WordCloudRandomiser {
	//getting randomFont with the size (based on the frequency of the word)
	public abstract Font getRandomFont(int frequencyofWord);
	//returns random Color
	public abstract Color getRandomColor();
}
