package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import dto.GameDto;
import dto.Player;
import entity.GameAct;
/**
 * 游戏逻辑类 
 * 实现游戏的控制逻辑
 * @author 高君宇
 *
 */
public class GameService {
	private GameDto dto;
	private Random random = new Random();
	/**
	 * 方块种类个数 7
	 */
	private static final int MAX_TYPE = 7;
	
	public GameService(GameDto dto){
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		dto.setGameAct(act);
	}
	/**
	 * 方块操作（上）
	 */
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	/**
	 * 方块操作（下）
	 * 
	 */
	public void keyDown() {
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return;
		}
		//获得游戏地图对象
		//这里用到了LayerGame类中一样的游戏地图，dto为同一个对象（在main方法中创建）
		boolean[][]map = this.dto.getGameMap();
		Point[]act = this.dto.getGameAct().getActPoint();//对应上面的dto.setGameAct(act);
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		//判断是否可以消行
		//消行操作
		//算分操作
		//判断是否升级
		//升级
		
		/**
		 * 创建下一个方块(游戏刚开始时，上面代码已通过构造方法中的“new GameAct(random.nextInt(MAX_TYPE));”
		 * 随机生成了一个下落方块)dto.setGameAct(act);
		 */
		this.dto.getGameAct().init(this.dto.getNext()); //目前每次刚开始游戏 第二个方块总是“0”号方块长条，原因是GameDto类中的属性next初始化默认为0
		
		/**
		 * 这一步代码随机生成此后的再下一个方块，显示在"LayerNext"界面上，提示下一个随机生成的将要出现的方块
		 * 
		 */
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}
	/**
	 * 方块操作（左）
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}
	/**
	 * 方块操作（右）
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	
	//TODO==================== 测试专用方法====================
	public void testLevelUp() {
		int point = this.dto.getNowPoint();
		int rmLine = this.dto.getNowRemoveLine();
		int lv = this.dto.getNowLevel();
		point += 10;
		rmLine += 1;
		if(rmLine % 20 == 0){
			lv += 1;
		}
		this.dto.setNowPoint(point);
		this.dto.setNowRemoveLine(rmLine);
		this.dto.setNowLevel(lv);
	}
	
	public void setDbRecord(List<Player> players){
		this.dto.setDbRecord(players);
	}
	
	public void setDiskRecord(List<Player> players){
		this.dto.setDiskRecord(players);
	}
}
