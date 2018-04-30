package ui;

import java.awt.Graphics;

public class LayerNext extends Layer {

	public LayerNext(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		this.drawImageAtCenter(Img.NEXT_ACT[this.dto.getNext()], g);
		//所谓的数组映射，就是给一个数组下标，去取对应的内容，以此来代替switch case 
	}

}
