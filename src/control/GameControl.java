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

	public void keyUp() {
		this.service.keyUp();
		panel.repaint();
	}

	public void keyDown() {
		this.service.keyDown();
		panel.repaint();
	}

	public void keyLeft() {
		this.service.keyLeft();
		panel.repaint();
	}

	public void keyRight() {
		this.service.keyRight();
		panel.repaint();
	}	
	
}
