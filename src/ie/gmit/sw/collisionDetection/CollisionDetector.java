package ie.gmit.sw.collisionDetection;
import java.awt.Rectangle;

public interface CollisionDetector {
	//Detecting collision of words by wrapping with rectangle
	public abstract boolean checkForCollision(Rectangle r);
}
