package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.FrameConfig;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerControl;
import dto.GameDto;


public class JPanelGame extends JPanel{

	private static final long serialVersionUID = 1L;

	private List<Layer> layers = null;
	
	private GameDto dto = null;
	
	public JPanelGame(GameDto dto){
		//获得dto对象
		this.dto = dto;
		//初始化组件
		this.initComponent();
		//初始化层
		this.initLayer();
	}
	
	/** 
	 * 安装玩家控制器
	 * （在main方法中被调用）
	 */
	public void setGameControl(PlayerControl playerControl){
		this.addKeyListener(playerControl);
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		
		
	}
	/**
	 * 初始化层
	 */
	private void initLayer(){
		try {
			//获得游戏配置。用单例的游戏配置，把本地磁盘的配置文件读到程序里，好处是比从本地磁盘读数据快。
			FrameConfig fCfg = GameConfig.getFrameConfig();
			//获得窗口（层）配置
			List<LayerConfig> layersCfg= fCfg.getLayersConfig();
			//创建游戏层数组
			layers = new ArrayList<Layer>(layersCfg.size());
			//循环所有层对象
			for(LayerConfig layerCfg:layersCfg){
				//获得类对象
				Class<?> cls = Class.forName(layerCfg.getClassName());
				//获得构造函数
				Constructor ctr = cls.getConstructor(int.class,int.class,int.class,int.class);
				//调用构造函数创建对象
				Layer layer = (Layer)ctr.newInstance(
						layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
				);
				//设置游戏数据对象  
				layer.setDto(dto);
				//把创建的layer对象放入集合，用与之后绘制出游戏界面。
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	/**
	 * 继承并重写父类JPanel的方法，没搞明白没找到到这个方法在哪里被调用到了？
	 * 但是不写又绘制不出游戏画面！
	 * 搜索到的答案是：
	 * 【当java认为需要重新绘制组件的时候由java自动调用。
	 * 比如你在程序中执行repaint();或者程序窗口最小化，然后恢复。
	 * 或者程序窗口被遮挡，又显现的时候。
	 * 我们平常并不用管这个方法，这个方法只在你需要继承paintComponent(一般是JFrame)的时候，重写方法，就可以了。】
	 * 
	 * 意思就是说：虽然你看不到这个方法在程序哪里被调用了，其实它是由JAVA自动调用的（JAVA认为需要重新绘制组件时），
	 * 我们平常写代码时，只需要重写这个方法就OK，并不用追寻找不到程序里哪调用了这个方法。
	 */
	public void paintComponent(Graphics g){
		//调用父类方法(暂时没发现不写有什么影响。)
		super.paintComponent(g);
		//绘制游戏界面
		for(int i=0;i<layers.size();i++){
			layers.get(i).paint(g);
		}
		//返回焦点（获取焦点到当前控件,也就是让面板知道玩家的键盘动作（让焦点保持在PANEL上），不写按键盘没反应.）
		//不写可能焦点落在PANEL外
		this.requestFocus();
	}
}
