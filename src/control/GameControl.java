package control;

import service.GameService;
import ui.JPanelGame;

public class GameControl {
	
	private JPanelGame panel;
	
	private GameService service;

	public GameControl(JPanelGame panel, GameService service) {
		super();
		this.panel = panel;
		this.service = service;
	}

	public void test() {
		this.service.gameTest();
		this.panel.repaint(); 
	}
	
	
	
}
