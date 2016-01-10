package ie.gmit.sw.paint;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * {@link WordCloudGraphics} implements {@link Graphicator}. This class contains
 * all the relevent methods needed for wordcloud graphics. All other
 * {@link java.awt.Graphics} methods has been encapsulated. The public methods
 * allows to configure the graphics/color/fonts in various ways.
 * 
 */

public class WordCloudGraphics implements Graphicator {

	private static final int WIDTH = 1300; // image width
	private static final int HEIGHT = 700; // image height

	private static BufferedImage wordCloudPNG = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	private static Graphics graphics = wordCloudPNG.getGraphics();
	private String imageName;;

	// default constructor
	public WordCloudGraphics() {
		setBackgroundColor(); // setting the background
	}

	// setting the background
	private void setBackgroundColor() {
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.setPaint(new Color(0, 0, 0));
		g2d.fillRect(0, 0, wordCloudPNG.getWidth(), wordCloudPNG.getHeight());
	}

	// initialization of graphics
	public WordCloudGraphics(Font f, Color c) {
		setBackgroundColor();
		setColor(c);
		setFont(f);
	}

	// setting the color
	public void setColor(Color color) {
		graphics.setColor(color);
	}

	// setting the font
	public void setFont(Font font) {
		graphics.setFont(font);

	}

	// returning the width of the string based on the font size
	public int getFontWidth(String word) {
		return graphics.getFontMetrics().stringWidth(word.toUpperCase());
	}

	// returning height
	public int getFontHeight() {
		return graphics.getFontMetrics().getHeight();
	}

	public void dispose() {
		graphics.dispose();
	}

	// generating png image
	/**
	 * @param filename
	 *            Image file name.
	 * @return returns boolean indicating whether the image was generated and
	 *         saved properly.
	 * @exception IOException
	 *                will be thrown if saving is not successful.
	 */
	public boolean generatePNGGraphics(String fileName) throws IOException {
		try {
			this.imageName = fileName;
			ImageIO.write(wordCloudPNG, "png", new File(imageName));
			return true; // if successful
		} catch (Exception e) {
			return false;
		}
	}

	// drawing word
	/**
	 * This method draws the word on a graphics.
	 * 
	 * @param word
	 *            Word to be drawn
	 * @param xCordinate
	 *            xCoordinate for the word
	 * @param yCoordinate
	 *            yCcoordinate for the word
	 */
	public void drawWord(String word, int xCoordinate, int yCoordinate) {
		graphics.drawString(word.trim().toUpperCase().trim(), xCoordinate, yCoordinate);
	}

	// rotated text - a bit of math's
	/**
	 * This method draws and rotate the word at 90 degrees.
	 */
	public void drawRotatedWord(String word, int xCordinate, int yCordinate) {
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate((float) xCordinate, (float) yCordinate);
		g2d.rotate(Math.toRadians(90));
		g2d.drawString(word.toUpperCase().trim(), 0, 0);
		g2d.rotate(-Math.toRadians(90));
		g2d.translate(-(float) xCordinate, -(float) yCordinate);

	}

}
