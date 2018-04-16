package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer{

	private static final Image IMG_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();
	
	private static final Image IMG_NUMBER = new ImageIcon("Graphics/string/num.png").getImage();
	
	private static final int IMG_NUMBER_W = 26;
	private static final int IMG_NUMBER_H = 36;
	
	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_LEVEL, this.x + PADDING, this.y + PADDING, null);
		this.drawNumber(32, 32, 6, g);
	}
	
	private void drawNumber(int x,int y,int num,Graphics g) {
		g.drawImage(IMG_NUMBER, 
				this.x + x, this.y + y, 
				this.x + x + IMG_NUMBER_W, this.y + y + IMG_NUMBER_H, 
				num*IMG_NUMBER_W, 0, (num+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
	}
}
