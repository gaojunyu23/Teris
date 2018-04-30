package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;

import entity.GameAct;
/**
 * 游戏数据显示类
 * （DTO=data transfer object）
 * @author 高君宇
 *
 */
public class GameDto {
	private static final int GAMEZONE_W = GameConfig.getSystemConfig().getMaxX() + 1;
	private static final int GAMEZONE_H = GameConfig.getSystemConfig().getMaxY() + 1;
	
	/*
	 * 数据库记录
	 */
	private List<Player> dbRecord;
	/*
	 * 本地记录
	 */
	private List<Player> diskRecord;
	/*
	 * 游戏地图(储存已经堆积的方块)
	 */
	private boolean[][] gameMap;
	/*
	 * 下落方块
	 */
	private GameAct gameAct;
	/*
	 * 下一个方块
	 */
	private int next ;
	//private int next = new Random().nextInt(6);
	
	/*
	 * 当前等级
	 */
	private int nowLevel;
	/*
	 * 当前分数
	 */
	private int nowPoint;
	/*
	 * 消除的行数
	 */
	private int nowRemoveLine;
	
	/**
	 * 
	 * 构造函数
	 */
	public GameDto(){
		dtoInit();
	}
	public void dtoInit(){
		this.gameMap = new boolean[GAMEZONE_W][GAMEZONE_H];
		//TODO 初始化所有游戏对象
	}
	
	public List<Player> getDbRecord() {
		return dbRecord;
	}

	public void setDbRecord(List<Player> dbRecord) {
		
		this.dbRecord = this.setFillRecord(dbRecord);
	}
	
	public List<Player> getDiskRecord() {
		return diskRecord;
	}

	public void setDiskRecord(List<Player> diskRecord) {
		
		this.diskRecord = this.setFillRecord(diskRecord);
	}

	private List<Player> setFillRecord(List<Player> players){
		//如果进来的是空，就创建
		if(players == null){
			players = new ArrayList<Player>();
		}
		//如果记录数小于5，就加到5条为止
		while(players.size() < 5){
			players.add(new Player("No Data",0));
		}
		Collections.sort(players);
		return players;
	}
	
	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNowLevel() {
		return nowLevel;
	}

	public void setNowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
	
}
