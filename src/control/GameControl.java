package control;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import config.DataInterfaceConfig;
import config.GameConfig;
import service.GameService;
import ui.JPanelGame;
import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dao.DataTest;
/**
 * 接收玩家键盘事件（由玩家控制类调用）
 * 控制画面
 * 控制游戏逻辑（调用游戏逻辑类）
 * @author 高君宇
 *
 */
public class GameControl {
	/**
	 * 数据访问接口A
	 */
	private Data dataA;
	
	/**
	 * 数据访问接口B
	 */
	private Data dataB;
	
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
		//获得类对象
		this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
		//设置数据库记录到游戏
		this.gameService.setDbRecord(dataA.loadData());
		//从数据接口B获得本地磁盘记录
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		//设置本地磁盘记录到游戏
		this.gameService.setDiskRecord(dataB.loadData());
	}
	/**
	 * 创建数据对象
	 * @param cfg
	 * @return
	 */
	private Data createDataObject(DataInterfaceConfig cfg){
		try {
			//获得类对象
			Class<?> cls = Class.forName(cfg.getClassName());
			//获得构造器
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
			//创建对象
			return (Data)ctr.newInstance(cfg.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		

	}
	
	/**
	 * 控制方向键（上）
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint(); //repaint不写的话画面不会更新;(JPanel的二逼套路，不写不行)
	}
	/**
	 * 控制方向键（下）
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	/**
	 * 控制方向键（左）
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	/**
	 * 控制方向键（右）
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint(); 
	}
	
	//TODO==================== 测试专用方法====================
	public void testLevelUp() {
		this.gameService.testLevelUp();
		this.panelGame.repaint(); //这句不加不刷新
	}


}
