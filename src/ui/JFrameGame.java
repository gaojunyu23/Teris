package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.FrameConfig;
import config.GameConfig;

public class JFrameGame extends JFrame{
	public JFrameGame(JPanelGame panelGame){
		//�����Ϸ����
		FrameConfig fCfg = GameConfig.getFrameConfig();
		//���ñ���
		this.setTitle(fCfg.getTitle());
		//����Ĭ�Ϲرգ���������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(fCfg.getWidth(),fCfg.getHeight());
		//���ò������û��ı䴰�ڴ�С
		this.setResizable(false);
		//���þ���,�û���ʾ����С��һ�����Ȼ�ȡ�û���ʾ����С
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		//������Ϸ�� ����Ϸ����λ����Ļ�м�  ���������
		int x = (screen.width - this.getWidth())>>1;
		int y = (screen.height - this.getHeight()>>1)-fCfg.getWindowUp();
		this.setLocation(x, y);
		//�ڴ��ڿ���������
		this.setContentPane(panelGame);
		//Ĭ�ϸô���Ϊ��ʾ
		this.setVisible(true);
	}
}
