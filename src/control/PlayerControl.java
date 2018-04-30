package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * 玩家控制类
 * 操控 GameControl
 * 将调用游戏控制类
 *
 */
public class PlayerControl extends KeyAdapter{
	
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	/**
	 * 键盘按下事件
	 */
	@Override
	public void keyPressed(KeyEvent e){
		//TODO这样的枚举写法不好
		//switch case :新手专用   数据中有规律的不要用枚举，想办法用算法解决
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_S:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_A:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_D:
			this.gameControl.keyRight();
			break;
		case KeyEvent.VK_UP:
			this.gameControl.testLevelUp();
		default:
			break;
		}
	}
	
}
