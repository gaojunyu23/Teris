package ui;

import java.awt.Graphics;
import java.awt.Point;

import config.GameConfig;

public class LayerGame extends Layer {

	/*
	 * ��λ��ƫ����
	 */
	private static final int SIZE_ROL = GameConfig.getFrameConfig().getSizeRol();//λ��ƫ����32
	
	private static final int LEFT_SIDE = 0;
	
	private static final int RIGHT_SIDE = GameConfig.getSystemConfig().getMaxX();
	
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		
		//��÷������鼯��
		Point[] points = this.dto.getGameAct().getActPoint();
		
		//�������䷽����Ӱ
		//TODO�ر���ӰЧ��
		this.drawShadow(points,true,g);
		
		//��÷������ͱ��(0~6)
		int typeCode = this.dto.getGameAct().getTypeCode();
		//���Ʒ���
		for (int i = 0; i < points.length; i++) {
			drawActByPoint( points[i].x,points[i].y, typeCode+1, g);

		}
		//���滭�������ǵ�ǰ�µķ���
		
		//���Ƶ�ͼ     ��GameService���е���Ϸ��ͼ��dtoΪͬһ��������main�����д�������  �����ݵ�ǽ�ϵķ���
		boolean[][] map = this.dto.getGameMap();
		
		//���㵱ǰ�ѻ���ɫ
		int lv = this.dto.getNowLevel();
		int imgIdx = lv == 0 ? 0 : (lv - 1) % 7 + 1;
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if( map[x][y] ){
					drawActByPoint( x, y,imgIdx, g); 
				}
			}
		}
	}
	/**
	 * ������ӰЧ��
	 * @param points
	 * @param b
	 */
	private void drawShadow(Point[] points, boolean isShowShadow,Graphics g) {
		if(!isShowShadow){
			return;
		}

		int leftX = RIGHT_SIDE; //9
		int rightX = LEFT_SIDE; //0
		for (Point p : points) {
			leftX = p.x < leftX ? p.x : leftX;
			rightX = p.x > rightX ? p.x : rightX;
		}
		 g.drawImage(Img.SHADOW,
			 this.x + BORDER + (leftX << SIZE_ROL), 
			 this.y + BORDER, 
			 (rightX - leftX + 1) << SIZE_ROL, 
			 this.h - (BORDER << 1),
			 null
		 );
	}
	/**
	 * ���������ο�   (+7��ȥ����Ϸģ��ı߿�ֵ)
	 */
	private void drawActByPoint(int x,int y,int imgIdx,Graphics g){
		g.drawImage(Img.ACT,
				this.x + (x<<SIZE_ROL) + 7, 
				this.y + (y<<SIZE_ROL) + 7, 
				this.x + (x<<SIZE_ROL) + (1<<SIZE_ROL) + 7, 
				this.y + (y<<SIZE_ROL) + (1<<SIZE_ROL) + 7, 
				imgIdx <<SIZE_ROL, 0, (imgIdx<<SIZE_ROL) + (1<<SIZE_ROL), (1<<SIZE_ROL), null);
	}
}
