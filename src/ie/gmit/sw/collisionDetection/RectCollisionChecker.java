package ie.gmit.sw.collisionDetection;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class RectCollisionChecker implements CollisionDetector {

	private List<Rectangle> rectList = new ArrayList<Rectangle>();

	public RectCollisionChecker() {

	}

	public boolean checkForCollision(Rectangle r) {
		boolean collision = false;
		if (rectList.size() == 0) {
			rectList.add(r);
			return collision;
		} else {
			// loop through the list
			Rectangle currRectangle;
			for (int i = 0; i < rectList.size(); i++) {
				currRectangle = rectList.get(i);
				if (r.intersects(currRectangle)) {
					return true;
				}
			}
			rectList.add(r);
			return collision;
		}
	}
}
