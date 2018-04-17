package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerControl extends KeyAdapter{
	
	private GameControl gameControl;

	public PlayerControl(GameControl gameControl) {
		super();
		this.gameControl = gameControl;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		//����
		case KeyEvent.VK_W:
			this.gameControl.keyUp();
			break;
		//����
		case KeyEvent.VK_S:
			this.gameControl.keyDown();
			break;
		//����
		case KeyEvent.VK_A:
			this.gameControl.keyLeft();
			break;
		//����
		case KeyEvent.VK_D:
			this.gameControl.keyRight();
			break;
		//ceshi
		case KeyEvent.VK_UP:
			this.gameControl.testLevelUp();
			break;
		default:
			break;
		}
	}
	
	
	
}
