package ie.gmit.sw.wordcloudtest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.randomStrategy.Coordinate;
import ie.gmit.sw.randomStrategy.CordinateGenerator;

public class CoordinateTest {

	CordinateGenerator coordiante;

	@Before
	public void setUp() throws Exception {
		coordiante = new Coordinate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int max = 1100;
		int min = 1;

		int val = coordiante.getX(max);

		assertTrue(val >= min || val <= max);
	}

}
