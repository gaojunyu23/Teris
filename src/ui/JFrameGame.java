package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.FrameConfig;
import config.GameConfig;

public class JFrameGame extends JFrame{
	public JFrameGame(JPanelGame panelGame){
		//获得游戏配置
		FrameConfig fCfg = GameConfig.getFrameConfig();
		//设置标题
		this.setTitle(fCfg.getTitle());
		//设置默认关闭（结束程序）
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(fCfg.getWidth(),fCfg.getHeight());
		//设置不允许用户改变窗口大小
		this.setResizable(false);
		//设置居中,用户显示器大小不一样，先获取用户显示器大小
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		//运行游戏后 让游戏窗体位于屏幕中间  看着舒服点
		int x = (screen.width - this.getWidth())>>1;
		int y = (screen.height - this.getHeight()>>1)-fCfg.getWindowUp();
		this.setLocation(x, y);
		//在窗口框里添加面板
		this.setContentPane(panelGame);
		//默认该窗口为显示
		this.setVisible(true);
	}
}
