package ie.gmit.sw.randomStrategy;

import java.util.Random;

import ie.gmit.sw.randomStrategy.CordinateGenerator;

public class Coordinate implements CordinateGenerator {

	private Random rand = new Random();

	// getting xCoordinate for placing the word
	public int getX(int max) {
		return rand.nextInt(max) + 1;
	}

	// getting yCoordinate
	public int getY(int min) {
		return rand.nextInt(min) + 1;
	}

}
