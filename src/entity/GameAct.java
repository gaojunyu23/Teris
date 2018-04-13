package entity;

import java.awt.Point;

public class GameAct {
	
	private Point[] actPoints;

	public GameAct() {
		//TODOÓ²±àÂë
		actPoints = new Point[]{
			new Point(3,0),
			new Point(4,0),
			new Point(5,0),
			new Point(5,1)
		};
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	/**
	 * ·½¿éÒÆ¶¯
	 */
	public void  move(int moveX,int moveY) {
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
	}
	
}
