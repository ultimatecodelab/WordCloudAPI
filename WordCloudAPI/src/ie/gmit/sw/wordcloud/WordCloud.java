package ie.gmit.sw.wordcloud;

import ie.gmit.sw.collisionDetection.CollisionDetector;
import ie.gmit.sw.collisionDetection.RectCollisionChecker;
import ie.gmit.sw.paint.WordCloudGraphics;
import ie.gmit.sw.randomStrategy.Coordinate;
import ie.gmit.sw.randomStrategy.CordinateGenerator;
import ie.gmit.sw.randomStrategy.WordCloudRandomiser;
import ie.gmit.sw.randomStrategy.WordCloudStrategy;
import ie.gmit.sw.paint.Graphicator;

import java.awt.Rectangle;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class WordCloud {
	// Constants and variables
	private static final int PADDING = 6;
	private static final int MAX_Y_AXIS_FOR_ROTATED_TEXT = 675;
	private static final int MAX_RAND_X = 1019;
	private static final int MAX_RAND_Y = 519;

	private String wordCloudPNGFileName = "WordCloud.png";

	/*
	 * Graphics method has been encapsulated using the interface and only the
	 * methods defined in a interface are accessible, and all the unnecessary
	 * methods has been hidden/encapsulated.. Please see - Paintable interface
	 * declaration
	 */
	private Graphicator myGraphics = new WordCloudGraphics();
	private WordCloudRandomiser randomiser = new WordCloudStrategy();
	private CollisionDetector collisonChecker = new RectCollisionChecker();
	private CordinateGenerator coordinate = new Coordinate();

	private static int rotationChecker = 0;
	private boolean rotated = false;
	private boolean isListEmpty = false;

	public WordCloud(List<Word> listofWordsToBeDrawn) throws Exception {

		isListEmpty = beginProcess(listofWordsToBeDrawn);
		if (isListEmpty)
			System.out.println("Cannot create the wordcloud,you must have typed in the" + "wrong filename...");
	}

	private boolean beginProcess(List<Word> wordList) throws Exception {
		if (wordList.size() > 0) {
			initWords(wordList);
			saveWordCloudPNG();
			return false;
		} else
			return true;

	}

	// words initialization - list of words to be drawn
	private void initWords(List<Word> drawWordsList) {
		Collections.sort(drawWordsList); //sorting the collection
		Random rand = new Random();
		int size = drawWordsList.size();
		// top 100 words will be drawn Word class overrides equals()
		// compareTo() and hashCode() methods
		if (size >= 100)
			size = 100;

		for (int i = 0; i < size; i++) {
			Word temp = drawWordsList.get(i);
			assignFontAndColor(temp);
			computeWordPosition(rand, temp);
			rotationChecker++;
		}
	}

	private void assignFontAndColor(Word temp) {
		myGraphics.setColor((randomiser.getRandomColor()));
		myGraphics.setFont((randomiser.getRandomFont(temp.getFrequency())));
	}

	private void computeWordPosition(Random rand, Word temp) {

		rotated = false;

		int width = myGraphics.getFontWidth(temp.getWord()) + PADDING;
		int height = myGraphics.getFontHeight() + PADDING;
		Rectangle newRectangle;
		int tempVal = width;
		if (rotationChecker % 5 == 0 || rotationChecker == 3) {
			tempVal = width;
			width = height;
			height = tempVal;
			rotated = true;
			newRectangle = new Rectangle(coordinate.getX(MAX_RAND_X) - PADDING, coordinate.getY(MAX_RAND_Y), width,
					height);
		} else {
			newRectangle = new Rectangle(coordinate.getX(MAX_RAND_X) + PADDING, coordinate.getY(MAX_RAND_Y) + height,
					width, height);
		}

		while ((collisonChecker.checkForCollision(newRectangle))) {
			newRectangle.setLocation(coordinate.getX(MAX_RAND_X),
					coordinate.getY(MAX_RAND_Y) + myGraphics.getFontHeight());
			if (rotated) {
				while (newRectangle.getY() + myGraphics.getFontHeight() >= MAX_Y_AXIS_FOR_ROTATED_TEXT) {
					newRectangle.setLocation((int) newRectangle.getX(), (coordinate.getY(MAX_RAND_Y)));
				}
			} else {
				int fontWidth = myGraphics.getFontWidth(temp.getWord());
				while ((newRectangle.getX() + fontWidth > 1050)) {
					newRectangle.setLocation(coordinate.getX(MAX_RAND_X + PADDING),
							(int) newRectangle.getY() + myGraphics.getFontHeight());
				}
			}
		}

		int xCordinate = (int) newRectangle.getX();
		int yCordinate = (int) newRectangle.getY();

		if (rotated) {
			rotateAndDraw(temp, xCordinate, yCordinate);
		} else {
			drawString(temp, xCordinate, yCordinate);
		}

	}

	private void rotateAndDraw(Word temp, int xCordinate, int yCordinate) {
		myGraphics.drawRotatedWord(temp.getWord(), xCordinate + (PADDING / 3), yCordinate + (PADDING / 2));
	}

	private void drawString(Word temp, int xCordinate, int yCordinate) {
		myGraphics.drawWord(temp.getWord(), xCordinate + (PADDING / 3), yCordinate + (PADDING / 2));
	}

	private void saveWordCloudPNG() throws Exception {
		if (myGraphics.generatePNGGraphics(wordCloudPNGFileName)) {
			System.out.println("WordCloud.png has been generated.");
		}
		myGraphics.dispose();
	}

}
