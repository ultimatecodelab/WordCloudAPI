package ie.gmit.sw.randomStrategy;

import java.util.Random;

import ie.gmit.sw.randomStrategy.CordinateGenerator;

public class Coordinate implements CordinateGenerator {

	private Random rand = new Random();

	@Override
	public int getX() {
		return rand.nextInt(1099) + 1;
	}

	@Override
	public int getY() {
		return rand.nextInt(540) + 1;
	}

}
