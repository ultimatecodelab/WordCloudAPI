package ie.gmit.sw.collisionDetection;

import java.awt.Rectangle;

/**
 * Interface for Collision Detection
 * 
 * @author Arjun Kharel
 *
 */
public interface CollisionDetector {
	/**
	 * @param rectangle
	 * @return returns  boolean for the collision.
	 */
	public abstract boolean checkForCollision(Rectangle rectangle);
}
