package ie.gmit.sw.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WordCloudGraphics implements Graphicator {

	private static final int WIDTH = 1300;
	private static final int HEIGHT = 700;

	private static BufferedImage wordCloudPNG = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
	private static Graphics graphics = wordCloudPNG.getGraphics();
	private String imageName;;

	public WordCloudGraphics() {
		setBackgroundColor();
	}

	private void setBackgroundColor() {
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.setPaint(new Color(0, 0, 0));
		g2d.fillRect(0, 0, wordCloudPNG.getWidth(), wordCloudPNG.getHeight());
	}

	public WordCloudGraphics(Font f, Color c) {
		setBackgroundColor();
		setColor(c);
		setFont(f);
	}

	public void setColor(Color color) {
		graphics.setColor(color);

	}

	public void setFont(Font font) {
		graphics.setFont(font);

	}

	public int getFontWidth(String word) {
		return graphics.getFontMetrics().stringWidth(word.toUpperCase());
	}

	public int getFontHeight() {

		return graphics.getFontMetrics().getHeight();
	}

	public void dispose() {
		graphics.dispose();
	}

	@Override
	public boolean generatePNGGraphics(String fileName) throws IOException {
		try {
			this.imageName = fileName;
			ImageIO.write(wordCloudPNG, "png", new File(imageName));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void drawWord(String word, int xCordinate, int yCordinate) {
		graphics.drawString(word.trim().toUpperCase().trim(), xCordinate, yCordinate);
	}

	@Override
	public void drawRotatedWord(String word, int xCordinate, int yCordinate) {
		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate((float) xCordinate, (float) yCordinate);
		g2d.rotate(Math.toRadians(90));
		g2d.drawString(word.toUpperCase().trim(), 0, 0);
		g2d.rotate(-Math.toRadians(90));
		g2d.translate(-(float) xCordinate, -(float) yCordinate);

	}

}
