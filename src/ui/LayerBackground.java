package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {

	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		int idx = this.dto.getNowLevel() % Img.BG_LIST.size();
		g.drawImage(Img.BG_LIST.get(idx), 0, 0,1162,686,null);
	}

}
