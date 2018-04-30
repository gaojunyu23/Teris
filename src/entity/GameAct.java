package entity;

import java.awt.Point;
import java.util.List;

import config.GameConfig;
/**
 * 下落方块
 * @author 高君宇
 *
 */
public class GameAct {
	/**
	 * 方块数组
	 */
	private Point[] actPoints;
	/**
	 * 方块编号
	 */
	private int typeCode;
	
	private static final int MIN_X = GameConfig.getSystemConfig().getMinX();
	private static final int MIN_Y = GameConfig.getSystemConfig().getMinY();
	private static final int MAX_X = GameConfig.getSystemConfig().getMaxX();
	private static final int MAX_Y = GameConfig.getSystemConfig().getMaxY();
	private static final List<Point[]> TYPE_CONFIG = GameConfig.getSystemConfig().getTypeConfig();
	
	public GameAct(int typeCode){
		this.init(typeCode);
	}
	public void init(int typeCode){
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);//集合里有7个类型的方块，拿到某一个类型的方块（通过typeCode）,
													//这个方块本身又是一个Point类型的数组Point[]
		actPoints = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
	}
	public Point[] getActPoint() {
		return actPoints;
	}
	/**
	 * 方块移动
	 * @param moveX X轴偏移量
	 * @param moveY Y轴偏移量
	 */
	public boolean move(int moveX,int moveY,boolean[][] gameMap){

		//移动的处理
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if( this.isOverMap( newX, newY,gameMap)){
				return false;
			}
		}
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		return true;
	}
	/**
	 * 方块旋转（使用笛卡尔坐标系公式）
	 * A.x = O.y + O.x - B.y
	 * A.y = O.y - O.x + B.x
	 */
	public void round(boolean[][] gameMap){
		if(this.typeCode == 4){
			return;
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//TODO 判断是否可以旋转
			if(this.isOverMap(newX, newY,gameMap)){
				return;
			}
		}
		for(int i = 1; i < actPoints.length; i++){
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}	
	}
	/**
	 * 判断是否超出边界
	 * @param x
	 * @param y
	 * @param gameMap
	 * @return
	 */
	private boolean isOverMap(int x, int y,boolean[][] gameMap){
		return  x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y];
	}
	/**
	 * 获得方块类型编号
	 */
	public int getTypeCode() {
		return typeCode;
	}
	
}
