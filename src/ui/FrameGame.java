package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("all")
public class FrameGame extends JFrame{
	
	public FrameGame() {
		this.setTitle("Java(JDK8)�����˹����");
		this.setSize(1200, 700);
		//���ùر���Ϸ�Զ�������̨����
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//���ڴ�С�̶�
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int h = (int) screenSize.getHeight();
		int w = (int) screenSize.getWidth();
		
		//������Ϸ���ھ�����ʾ
		this.setLocation((w-this.getWidth())>>1,(h-this.getHeight())>>1);
		this.setContentPane(new PanelGame());
	}
	
}
