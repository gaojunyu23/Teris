package ui;

import java.awt.Graphics;

public class LayerNext extends Layer {

	public LayerNext(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		this.drawImageAtCenter(Img.NEXT_ACT[this.dto.getNext()], g);
		//��ν������ӳ�䣬���Ǹ�һ�������±꣬ȥȡ��Ӧ�����ݣ��Դ�������switch case 
	}

}
