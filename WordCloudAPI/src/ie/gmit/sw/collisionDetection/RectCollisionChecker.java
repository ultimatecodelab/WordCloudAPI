package ie.gmit.sw.collisionDetection;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * RectCollisionChecker implements CollisionDetector Interface. This class is
 * responsible for checking whether the collision of shape (rectangle). This
 * class also maintains the list of Rectangle to ensure the collision is handled
 * efficiently.
 * 
 * @author Arjun Kharel
 *
 */
public class RectCollisionChecker implements CollisionDetector {
	/*
	 * List that holds the rectangles. When new rectangle is created at random
	 * We are looping through the list and detecting any collisions.
	 */
	private List<Rectangle> rectList = new ArrayList<Rectangle>();

	public RectCollisionChecker() {

	}

	// collision detection algorithms
	/**
	 * @param rectangle 
	 * @return returns boolean for the collision.
	 */
	public boolean checkForCollision(Rectangle r) {
		boolean collision = false;
		// list size = 0 , means we are creating the first rectangle only.
		if (rectList.size() == 0) {
			rectList.add(r);
			return collision;
		} else {
			// loop through the list
			Rectangle currRectangle;
			for (int i = 0; i < rectList.size(); i++) {
				currRectangle = rectList.get(i);
				if (r.getBounds2D().intersects(currRectangle.getBounds2D())) {
					return true; // collision
				}
			}
			rectList.add(r); // no collision
			return collision;
		}
	}
}
