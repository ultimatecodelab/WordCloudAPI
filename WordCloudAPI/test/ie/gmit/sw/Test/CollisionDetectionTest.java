package ie.gmit.sw.Test;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import ie.gmit.sw.collisionDetection.CollisionDetector;
import ie.gmit.sw.collisionDetection.RectCollisionChecker;

public class CollisionDetectionTest {
	CollisionDetector collisonDetection;

	@Before
	public void setUp() throws Exception {
		collisonDetection = new RectCollisionChecker();
	}

	@Test
	public void test() {

		Rectangle rect = new Rectangle(500, 400, 50, 80);
		Rectangle rect2 = new Rectangle(500, 470, 50, 35);

		// Test will pass in both cases.. when assertFalse is called, there is
		// only one rectangle created so collision is not expected for sure...
		// secondly : when asserTrue gets executed (rect) collided with rect2..

		assertFalse(collisonDetection.checkForCollision(rect));
		assertTrue(collisonDetection.checkForCollision(rect2));

	}

}
