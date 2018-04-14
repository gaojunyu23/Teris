package entity;

import java.awt.Point;

public class GameAct {
	
	private Point[] actPoints;

	//TODO
	private static final int MIN_X = 0;
	private static final int MAX_X = 9;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 17;
	
	public GameAct() {
		//TODOӲ����
		actPoints = new Point[]{
			new Point(4,0),
			new Point(3,0),
			new Point(5,0),
			new Point(5,1)
		};
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	/**
	 * �����ƶ�
	 * �˷�������˷����ƶ���ͬʱ�ַ������Ƿ��ƶ��ɹ��Ĳ���ֵ,
	 * �������ڷ����ƶ�����ʱ�������ݲ���ֵ����������
	 */
	public boolean  move(int moveX,int moveY) {
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(isOutMap(newX,newY)) {
				return false;
			}
		}
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
		return true;
	}
	
	/**
	 * ������ת
	 * ����˳ʱ����ת��ʽ(0�������ĵ�)��
	 * B.x = 0.y + 0.x - A.y
	 * B.y = 0.y - 0.x + A.x
	 */
	public void round() {
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//�ж��Ƿ������ת
			if(isOutMap(newX,newY)) {
				return;
			}
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}
	
	public boolean isOutMap(int newX,int newY) {
		return 	newX < MIN_X||newX > MAX_X||newY < MIN_Y||newY > MAX_Y;
	}
	
}
