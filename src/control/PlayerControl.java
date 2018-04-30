package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * ��ҿ�����
 * �ٿ� GameControl
 * ��������Ϸ������
 *
 */
public class PlayerControl extends KeyAdapter{
	
	private GameControl gameControl;
	
	public PlayerControl(GameControl gameControl){
		this.gameControl = gameControl;
	}
	/**
	 * ���̰����¼�
	 */
	@Override
	public void keyPressed(KeyEvent e){
		//TODO������ö��д������
		//switch case :����ר��   �������й��ɵĲ�Ҫ��ö�٣���취���㷨���
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
