package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

public abstract class Layer {
	
	//�߿�ѡ��ͼƬ
	private Image img = new ImageIcon("Graphics/window/Window.png").getImage();
	private static final Image IMG_NUMBER = new ImageIcon("Graphics/string/num.png").getImage();

	protected static final int IMG_NUMBER_W = IMG_NUMBER.getWidth(null)/10;
	private static final int IMG_NUMBER_H = IMG_NUMBER.getHeight(null);
	//������߿�ľ���
	protected final static int PADDING;
	//���ڱ߿��ߴֶ�
	private final static int BORDER;
	
	protected static GameDto dto = null;
	static {
		GameConfig gameConfig = ConfigFactory.getGameConfig();
		PADDING = gameConfig.getPadding();
		BORDER =  gameConfig.getBorder();
	}
	
	protected int x;
	protected int y;
	protected int w;
	protected int h;

	private int imgW = img.getWidth(null);
	private int imgH = img.getHeight(null);

	public Layer(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * �����ṩ�Ŀ�����Ʒ���
	 * @param g
	 */
	public void createWindow(Graphics g) {
		//����
		g.drawImage(img, x, y, x+BORDER, y+BORDER, 0, 0, BORDER, BORDER, null);
		//����
		g.drawImage(img, x+BORDER, y, x+w-BORDER, y+BORDER, BORDER, 0, imgW-BORDER, BORDER, null);
		//����
		g.drawImage(img, x+w-BORDER, y, x+w, y+BORDER, imgW-BORDER, 0, imgW, BORDER, null);
		//����
		g.drawImage(img, x, y+BORDER, x+BORDER, y+h-BORDER, 0, BORDER, BORDER, imgH-BORDER, null);
		//��
		g.drawImage(img, x+BORDER, y+BORDER, x+w-BORDER, y+h-BORDER, BORDER, BORDER, imgW-BORDER, imgH-BORDER, null);
		//����
		g.drawImage(img, x+w-BORDER, y+BORDER, x+w, y+h-BORDER, imgW-BORDER, BORDER, imgW, imgH-BORDER, null);
		//����
		g.drawImage(img, x, y+h-BORDER, x+BORDER, y+h, 0, imgH-BORDER, BORDER, imgH, null);
		//����
		g.drawImage(img, x+BORDER, y+h-BORDER, x+w-BORDER, y+h, BORDER, imgH-BORDER, imgW-BORDER, imgH, null);
		//����
		g.drawImage(img, x+w-BORDER, y+h-BORDER, x+w, y+h, imgW-BORDER, imgH-BORDER, imgW, imgH, null);
	}
	
	protected abstract void paint(Graphics g);

	public static void setDto(GameDto dto) {
		Layer.dto = dto;
	}
	
	protected void drawNumber(int x,int y,int num,int maxBit,Graphics g) {
		String numStr = String.valueOf(num);
		//ѭ�������Ҷ�������
		for (int i = 0; i < maxBit; i++) {
			//�ж��Ƿ������������
			if(maxBit-i <= numStr.length()) {
				int idx = i - maxBit +numStr.length();
				int cNum = numStr.charAt(idx)-'0';
				g.drawImage(IMG_NUMBER, 
						this.x + x + IMG_NUMBER_W*i, this.y + y, 
						this.x + x + IMG_NUMBER_W*(i+1), this.y + y + IMG_NUMBER_H, 
						cNum*IMG_NUMBER_W, 0, (cNum+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
			}
			
		}
	}
}
