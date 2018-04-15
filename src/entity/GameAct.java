package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	
	private Point[] actPoints;

	private int typeCode;

	//TODO Ӳ����
	private static final int MIN_X = 0;
	private static final int MAX_X = 9;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 17;
	//TODO Ӳ����
	private static List<Point[]> TYPE_CONFIG = new ArrayList<Point[]>(7);
	static {
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(3,1),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1)});
	}
	public GameAct(int typeCode) {
		this.init(typeCode);
	}
	
	public void init(int typeCode) {
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	public int getTypeCode() {
		return typeCode;
	}
	/**
	 * �����ƶ�
	 * �˷�������˷����ƶ���ͬʱ�ַ������Ƿ��ƶ��ɹ��Ĳ���ֵ,
	 * �������ڷ����ƶ�����ʱ�������ݲ���ֵ����������
	 */
	public boolean  move(int moveX,int moveY,boolean[][]gameMap) {
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(isOutZone(newX,newY,gameMap)) {
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
	public void round(boolean[][]gameMap) {
		//TODO Ӳ����
		if(this.typeCode == 4) {
			return;
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//�ж��Ƿ������ת
			if(isOutZone(newX,newY,gameMap)) {
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
	
	/**
	 * �����߽�
	 * @param newX
	 * @param newY
	 * @param gameMap
	 * @return
	 */
	public boolean isOutZone(int newX,int newY,boolean[][] gameMap) {
		return 	newX < MIN_X||newX > MAX_X||newY < MIN_Y||newY > MAX_Y||gameMap[newX][newY];
	}
	
}
