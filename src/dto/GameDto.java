package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	
	/**
	 * ���ݿ���Ҽ�¼
	 */
	private List<Player> dbRecoder;
	
	/**
	 * ��ұ��ؼ�¼
	 */
	private List<Player> diskRecoder;
	
	/**
	 * ��Ϸ��ͼ
	 */
	private boolean[][] gameMap;
	
	/**
	 * ��Ϸ���䷽��
	 */
	private GameAct gameAct;
	
	/**
	 * ��һ������
	 */
	private int next;
	
	/**
	 * ��ǰ�ȼ�
	 */
	private int level;
	
	/**
	 * ��ǰ�÷�
	 */
	private int nowPoint;
	
	/**
	 *������
	 */
	private int nowRemoveLine;

	public GameDto() {
		this.init();
	}
	
	public void init() {
		this.gameMap = new boolean[10][18];
	}
	
	public List<Player> getDbRecoder() {
		return dbRecoder;
	}

	public void setDbRecoder(List<Player> dbRecoder) {
		this.dbRecoder = dbRecoder;
	}

	public List<Player> getDiskRecoder() {
		return diskRecoder;
	}

	public void setDiskRecoder(List<Player> diskRecoder) {
		this.diskRecoder = diskRecoder;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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
