package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

@SuppressWarnings("all")
public class JFrameGame extends JFrame{
	
	public JFrameGame(JPanelGame jPanelGame) {
		GameConfig gameConfig = ConfigFactory.getGameConfig();
		this.setTitle(gameConfig.getTitle());
		this.setSize(gameConfig.getWidth(), gameConfig.getHeight());
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
		this.setContentPane(jPanelGame);
		this.setVisible(true);
	}
	
}
