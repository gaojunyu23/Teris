package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;

import entity.GameAct;
/**
 * ��Ϸ������ʾ��
 * ��DTO=data transfer object��
 * @author �߾���
 *
 */
public class GameDto {
	private static final int GAMEZONE_W = GameConfig.getSystemConfig().getMaxX() + 1;
	private static final int GAMEZONE_H = GameConfig.getSystemConfig().getMaxY() + 1;
	
	/*
	 * ���ݿ��¼
	 */
	private List<Player> dbRecord;
	/*
	 * ���ؼ�¼
	 */
	private List<Player> diskRecord;
	/*
	 * ��Ϸ��ͼ(�����Ѿ��ѻ��ķ���)
	 */
	private boolean[][] gameMap;
	/*
	 * ���䷽��
	 */
	private GameAct gameAct;
	/*
	 * ��һ������
	 */
	private int next ;
	//private int next = new Random().nextInt(6);
	
	/*
	 * ��ǰ�ȼ�
	 */
	private int nowLevel;
	/*
	 * ��ǰ����
	 */
	private int nowPoint;
	/*
	 * ����������
	 */
	private int nowRemoveLine;
	
	/**
	 * 
	 * ���캯��
	 */
	public GameDto(){
		dtoInit();
	}
	public void dtoInit(){
		this.gameMap = new boolean[GAMEZONE_W][GAMEZONE_H];
		//TODO ��ʼ��������Ϸ����
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
		//����������ǿգ��ʹ���
		if(players == null){
			players = new ArrayList<Player>();
		}
		//�����¼��С��5���ͼӵ�5��Ϊֹ
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
