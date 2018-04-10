package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("all")
public class FrameGame extends JFrame{
	
	public FrameGame() {
		this.setTitle("Java(JDK8)版俄罗斯方块");
		this.setSize(1200, 700);
		//设置关闭游戏自动结束后台进程
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//窗口大小固定
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int h = (int) screenSize.getHeight();
		int w = (int) screenSize.getWidth();
		
		//设置游戏窗口居中显示
		this.setLocation((w-this.getWidth())>>1,(h-this.getHeight())>>1);
		this.setContentPane(new PanelGame());
	}
	
}
