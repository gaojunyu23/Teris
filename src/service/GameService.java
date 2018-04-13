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
		if(this.canMove(0, -1)) {
			this.dto.getGameAct().move(0, -1);
		}
	}

	public void keyDown() {
		if(this.canMove(0, 1)) {
			this.dto.getGameAct().move(0, 1);
		}
	}

	public void keyLeft() {
		if(this.canMove(-1, 0)) {
			this.dto.getGameAct().move(-1, 0);
		}
	}

	public void keyRight() {
		if(this.canMove(1, 0)) {
			this.dto.getGameAct().move(1, 0);
		}
	}	
	
	public boolean canMove(int moveX,int moveY) {
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < actPoints.length; i++) {
			//TODO Ó²±àÂë
			if(actPoints[i].x+moveX<0||actPoints[i].x+moveX>9||actPoints[i].y+moveY<0||actPoints[i].y+moveY>17) {
				return false;
			}
		}
		return true;
	}
	
}
