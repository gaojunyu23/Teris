package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	
	private GameDto dto;
	
	private Random random = new Random();
	
	private static final int MAX_TYPE = 6;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		dto.setGameAct(act);
	}

	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}

	public void keyDown() {
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())) {
			return;
		}
		boolean[][] gameMap = this.dto.getGameMap();
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < actPoints.length; i++) {
			gameMap[actPoints[i].x][actPoints[i].y] = true;
		}
		//TODO 
		//判断是否可以消行
		//消行操作
		//算分操作
		//判断是否可以升级
		//升级
		//刷新一个新的方块
		this.dto.getGameAct().init(random.nextInt(MAX_TYPE));
	}

	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}

	public void keyRight() {
		this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}	
	
	
}
