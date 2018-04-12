package ui;

import java.awt.Font;
import java.awt.Graphics;

public class LayerGame extends Layer{

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
		g.setFont(new Font("ºÚÌå", Font.BOLD, 64));
		g.drawString(String.valueOf(this.dto.getNowPoint()), this.x + PADDING, this.y+PADDING);
	}
}
