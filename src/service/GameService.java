package service;

import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	
	private GameDto dto;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct();
		dto.setGameAct(act);
	}

	public void keyUp() {
		this.dto.getGameAct().round();
	}

	public void keyDown() {
		if(!this.dto.getGameAct().move(0, 1)) {
			boolean[][] gameMap = this.dto.getGameMap();
			Point[] actPoints = this.dto.getGameAct().getActPoints();
			for (int i = 0; i < actPoints.length; i++) {
				gameMap[actPoints[i].x][actPoints[i].y] = true;
			}
		}
	}

	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0);
	}

	public void keyRight() {
		this.dto.getGameAct().move(1, 0);
	}	
	
	
}
