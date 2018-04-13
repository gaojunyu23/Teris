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
		for (int i = 0; i < actPoints.length; i++) {
			g.drawImage(ACT, 
					this.x+actPoints[i].x*ACT_SIZE+7, 
					this.y+actPoints[i].y*ACT_SIZE+7, 
					this.x+actPoints[i].x*ACT_SIZE+ACT_SIZE+7, 
					this.y+actPoints[i].y*ACT_SIZE+ACT_SIZE+7, 
					ACT_SIZE, 0, ACT_SIZE<<1, ACT_SIZE, null);
		}
	}
}
