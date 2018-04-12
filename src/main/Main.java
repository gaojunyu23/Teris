package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String[] args) {
		//创建游戏数据源
		GameDto dto = new GameDto();
		//创建游戏面板
		JPanelGame jPanelGame = new JPanelGame(dto);
		//创建游戏逻辑处理块
		GameService service = new GameService(dto);
		//创建游戏控制器(连接游戏面板与逻辑处理块)
		GameControl gameControl = new GameControl(jPanelGame,service);
		//创建玩家 控制器(连接游戏控制器)
		PlayerControl playerControl = new PlayerControl(gameControl);
		jPanelGame.setPlayerControl(playerControl);
		new JFrameGame(jPanelGame);
		
	}
}
