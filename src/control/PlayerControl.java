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
		//向上
		case KeyEvent.VK_W:
			this.gameControl.keyUp();
			break;
		//向下
		case KeyEvent.VK_S:
			this.gameControl.keyDown();
			break;
		//向左
		case KeyEvent.VK_A:
			this.gameControl.keyLeft();
			break;
		//向右
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
