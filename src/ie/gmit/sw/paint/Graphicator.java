package ie.gmit.sw.paint;

import java.awt.Color;
import java.awt.Font;

public interface Graphicator {
	// to encapsulate the java Graphics -- see the implementing class
	// CreateGraphics
	public abstract void setColor(Color color);

	public abstract void setFont(Font font);

	public abstract int getFontWidth(String word);

	public abstract int getFontHeight();

	public abstract void dispose();

	public abstract boolean generatePNGGraphics(String imageName) throws Exception;

	public abstract void drawWord(String word, int xCordinate, int yCordinate);

	public abstract void drawRotatedWord(String word, int xCordinate, int yCordinate);

}