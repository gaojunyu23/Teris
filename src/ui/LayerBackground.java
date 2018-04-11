package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer{

	private static Image IMG_TEMP = new ImageIcon("Graphics/background/bg01.jpg").getImage();
	
	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	protected void paint(Graphics g) {
		g.drawImage(IMG_TEMP, 0, 0, 1200, 700, null);
	}

}
