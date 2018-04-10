package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Layer {
	
	//�߿�ѡ��ͼƬ
	private Image img = new ImageIcon("Graphics/window/Window.png").getImage();
	
	//������߿�ľ���
	protected final static int PADDING = 16;
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	private final int size = 7;
	private int imgW = img.getWidth(null);
	private int imgH = img.getHeight(null);

	public Layer(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public void createWindow(Graphics g) {
		//����
		g.drawImage(img, x, y, x+size, y+size, 0, 0, size, size, null);
		//����
		g.drawImage(img, x+size, y, x+w-size, y+size, size, 0, imgW-size, size, null);
		//����
		g.drawImage(img, x+w-size, y, x+w, y+size, imgW-size, 0, imgW, size, null);
		//����
		g.drawImage(img, x, y+size, x+size, y+h-size, 0, size, size, imgH-size, null);
		//��
		g.drawImage(img, x+size, y+size, x+w-size, y+h-size, size, size, imgW-size, imgH-size, null);
		//����
		g.drawImage(img, x+w-size, y+size, x+w, y+h-size, imgW-size, size, imgW, imgH-size, null);
		//����
		g.drawImage(img, x, y+h-size, x+size, y+h, 0, imgH-size, size, imgH, null);
		//����
		g.drawImage(img, x+size, y+h-size, x+w-size, y+h, size, imgH-size, imgW-size, imgH, null);
		//����
		g.drawImage(img, x+w-size, y+h-size, x+w, y+h, imgW-size, imgH-size, imgW, imgH, null);
	}
	
	protected abstract void paint(Graphics g);
}
