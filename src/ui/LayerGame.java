package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

@SuppressWarnings("all")
public class LayerGame extends Layer{

	private static Image ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	
	private static final int ACT_SIZE = 32;
	
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		//画出方块
		for (int i = 0; i < actPoints.length; i++) {
			g.drawImage(ACT, 
					this.x+actPoints[i].x*ACT_SIZE+7, 
					this.y+actPoints[i].y*ACT_SIZE+7, 
					this.x+actPoints[i].x*ACT_SIZE+ACT_SIZE+7, 
					this.y+actPoints[i].y*ACT_SIZE+ACT_SIZE+7, 
					ACT_SIZE, 0, ACT_SIZE<<1, ACT_SIZE, null);
		}
		//画出地图
		boolean[][] gameMap = this.dto.getGameMap();
		for (int x = 0; x < gameMap.length; x++) {
			for (int y = 0; y < gameMap[x].length; y++) {
				if(gameMap[x][y]) {
					g.drawImage(ACT, 
							this.x+ x*ACT_SIZE+7, 
							this.y+ y*ACT_SIZE+7, 
							this.x+ x*ACT_SIZE+ACT_SIZE+7, 
							this.y+ y*ACT_SIZE+ACT_SIZE+7, 
							0, 0, ACT_SIZE, ACT_SIZE, null);
				}
			}
		}
		
	}
}
