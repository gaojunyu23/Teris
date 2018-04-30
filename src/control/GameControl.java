package control;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import config.DataInterfaceConfig;
import config.GameConfig;
import service.GameService;
import ui.JPanelGame;
import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dao.DataTest;
/**
 * ������Ҽ����¼�������ҿ�������ã�
 * ���ƻ���
 * ������Ϸ�߼���������Ϸ�߼��ࣩ
 * @author �߾���
 *
 */
public class GameControl {
	/**
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	
	/**
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;
	
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
		//��������
		this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
		//�������ݿ��¼����Ϸ
		this.gameService.setDbRecord(dataA.loadData());
		//�����ݽӿ�B��ñ��ش��̼�¼
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		//���ñ��ش��̼�¼����Ϸ
		this.gameService.setDiskRecord(dataB.loadData());
	}
	/**
	 * �������ݶ���
	 * @param cfg
	 * @return
	 */
	private Data createDataObject(DataInterfaceConfig cfg){
		try {
			//��������
			Class<?> cls = Class.forName(cfg.getClassName());
			//��ù�����
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
			//��������
			return (Data)ctr.newInstance(cfg.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		

	}
	
	/**
	 * ���Ʒ�������ϣ�
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint(); //repaint��д�Ļ����治�����;(JPanel�Ķ�����·����д����)
	}
	/**
	 * ���Ʒ�������£�
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	/**
	 * ���Ʒ��������
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	/**
	 * ���Ʒ�������ң�
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint(); 
	}
	
	//TODO==================== ����ר�÷���====================
	public void testLevelUp() {
		this.gameService.testLevelUp();
		this.panelGame.repaint(); //��䲻�Ӳ�ˢ��
	}


}
