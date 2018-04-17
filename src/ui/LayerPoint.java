package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer{

	private static final Image IMG_POINT = new ImageIcon("Graphics/string/point.png").getImage();
	private static final Image IMG_RMLINE = new ImageIcon("Graphics/string/rmline.png").getImage();
	private static final int IMG_RMLINE_H = IMG_RMLINE.getHeight(null);
	
	private static final int POINT_Y = PADDING;
	private static final int RMLINE_Y = IMG_RMLINE_H+(PADDING<<1);
	
	private static final int POINT_BIT = 5;
	
	private static int POINT_X;
	
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		POINT_X = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
	}
	@Override
	protected void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_POINT,this.x+PADDING,this.y+PADDING,null);
		this.drawNumber(POINT_X, POINT_Y, this.dto.getNowPoint(), POINT_BIT, g);
		
		g.drawImage(IMG_RMLINE, this.x+PADDING, this.y+RMLINE_Y, null);
		this.drawNumber(POINT_X, RMLINE_Y, this.dto.getNowRemoveLine(), POINT_BIT, g);
	}
}
