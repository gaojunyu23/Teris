package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

@SuppressWarnings("all")
public class LayerGame extends Layer{

	private static Image ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	
	private static final int SIZE_ROL = 5;
	
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
		//获取方块数组集合
		Point[] actPoints = this.dto.getGameAct().getActPoints();
		//获得方块类型编号
		int typeCode = this.dto.getGameAct().getTypeCode();
		//画出方块
		for (int i = 0; i < actPoints.length; i++) {
			this.drawActByPoint(actPoints[i].x,actPoints[i].y,typeCode+1,g);
		}
		//画出地图
		boolean[][] gameMap = this.dto.getGameMap();
		for (int x = 0; x < gameMap.length; x++) {
			for (int y = 0; y < gameMap[x].length; y++) {
				if(gameMap[x][y]) {
					this.drawActByPoint(x,y,0,g);
				}
			}
		}
		
	}
	
	private void drawActByPoint(int x,int y,int imgIndex,Graphics g) {
		g.drawImage(ACT, 
				this.x+(x << SIZE_ROL)+7, 
				this.y+(y << SIZE_ROL)+7, 
				this.x+(x+1 << SIZE_ROL)+7, 
				this.y+(y+1 << SIZE_ROL)+7, 
				imgIndex<<SIZE_ROL, 0,(imgIndex+1)<<SIZE_ROL, 1<<SIZE_ROL, null);
	}
}
