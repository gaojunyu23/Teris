package ui;

import java.awt.Graphics;

public class LayAbout extends Layer{

	public LayAbout(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
	}
	
}
