package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer{

	private static final Image IMG_LEVEL = new ImageIcon("Graphics/string/level.png").getImage();
	
	private static final int IMG_LEVEL_W = IMG_LEVEL.getWidth(null);
	
	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
		int centerX = this.x + (this.w - IMG_LEVEL_W >>1);
		g.drawImage(IMG_LEVEL, centerX, this.y + PADDING, null);
		this.drawNumber(16, 64, this.dto.getLevel(),5, g);
	}
	
	
}
