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
		JPanelGame jPanelGame = new JPanelGame(dto);
		//������Ϸ�߼������
		GameService service = new GameService(dto);
		//������Ϸ������(������Ϸ������߼������)
		GameControl gameControl = new GameControl(jPanelGame,service);
		//������� ������(������Ϸ������)
		PlayerControl playerControl = new PlayerControl(gameControl);
		jPanelGame.setPlayerControl(playerControl);
		new JFrameGame(jPanelGame);
		
	}
}
