package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import dto.GameDto;
import dto.Player;
import entity.GameAct;
/**
 * ��Ϸ�߼��� 
 * ʵ����Ϸ�Ŀ����߼�
 * @author �߾���
 *
 */
public class GameService {
	private GameDto dto;
	private Random random = new Random();
	/**
	 * ����������� 7
	 */
	private static final int MAX_TYPE = 7;
	
	public GameService(GameDto dto){
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		dto.setGameAct(act);
	}
	/**
	 * ����������ϣ�
	 */
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	/**
	 * ����������£�
	 * 
	 */
	public void keyDown() {
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return;
		}
		//�����Ϸ��ͼ����
		//�����õ���LayerGame����һ������Ϸ��ͼ��dtoΪͬһ��������main�����д�����
		boolean[][]map = this.dto.getGameMap();
		Point[]act = this.dto.getGameAct().getActPoint();//��Ӧ�����dto.setGameAct(act);
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		//�ж��Ƿ��������
		//���в���
		//��ֲ���
		//�ж��Ƿ�����
		//����
		
		/**
		 * ������һ������(��Ϸ�տ�ʼʱ�����������ͨ�����췽���еġ�new GameAct(random.nextInt(MAX_TYPE));��
		 * ���������һ�����䷽��)dto.setGameAct(act);
		 */
		this.dto.getGameAct().init(this.dto.getNext()); //Ŀǰÿ�θտ�ʼ��Ϸ �ڶ����������ǡ�0���ŷ��鳤����ԭ����GameDto���е�����next��ʼ��Ĭ��Ϊ0
		
		/**
		 * ��һ������������ɴ˺������һ�����飬��ʾ��"LayerNext"�����ϣ���ʾ��һ��������ɵĽ�Ҫ���ֵķ���
		 * 
		 */
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}
	/**
	 * �����������
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}
	/**
	 * ����������ң�
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	
	//TODO==================== ����ר�÷���====================
	public void testLevelUp() {
		int point = this.dto.getNowPoint();
		int rmLine = this.dto.getNowRemoveLine();
		int lv = this.dto.getNowLevel();
		point += 10;
		rmLine += 1;
		if(rmLine % 20 == 0){
			lv += 1;
		}
		this.dto.setNowPoint(point);
		this.dto.setNowRemoveLine(rmLine);
		this.dto.setNowLevel(lv);
	}
	
	public void setDbRecord(List<Player> players){
		this.dto.setDbRecord(players);
	}
	
	public void setDiskRecord(List<Player> players){
		this.dto.setDiskRecord(players);
	}
}
