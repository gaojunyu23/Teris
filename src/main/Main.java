package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String[] args) {
		//������Ϸ����Դ
		GameDto dto = new GameDto();
		//������Ϸ���
		JPanelGame panel = new JPanelGame(dto);
		//������Ϸ�߼��飨������Ϸ����Դ��
		GameService service = new GameService(dto);
		//������Ϸ��������������Ϸ������Ϸ�߼��飩
		GameControl gameControl = new GameControl(panel,service);
		//������ҿ����� ������Ϸ������
		PlayerControl playerControl = new PlayerControl(gameControl);
		//��װ��ҿ�����
		panel.setGameControl(playerControl);
		//������Ϸ���� ��װ��Ϸ���
		JFrameGame jf = new JFrameGame(panel);
	}
}
