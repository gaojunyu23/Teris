package dao;

import java.util.List;

import dto.Player;

/**
 * ���ݳ־ò�ӿ�
 * @author �߾���
 *
 */
public interface Data {
	/**
	 * ��ȡ����
	 */
	public List<Player> loadData();
	 /**
	  * �洢����
	  */
	public void saveData(Player players);
}
