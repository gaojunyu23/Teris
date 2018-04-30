package ui;

import java.awt.Color;
import java.awt.Graphics;

import config.GameConfig;

public class LayerPoint extends Layer {
	/**
	 * �������λ��
	 */
	private static final int POINT_BIT = 5;
	/**
	 * �������� 
	 */
	private static final int LEVEL_UP = GameConfig.getSystemConfig().getLevelUp();
	
	/**
	 * "����"Y����
	 */
	private  final int rmline_y ;
	
	/**
	 * "����"Y����
	 */
	private  final int point_y; 
	
	/**
	 * ����ֵY����
	 */
	private final int expY;

	/**
	 * "����"��"����"��ͬ��X����
	 */
	private final int comX;
	
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		//��ʼ����ͨ��X����
		this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING ;
		//��ʼ��������Y����
		this.point_y = PADDING; 
		//��ʼ�� "����"Y����
		this.rmline_y = point_y + Img.POINT.getHeight(null) + PADDING ;

		//��ʼ������ֵ��Y����
		this.expY = rmline_y +  Img.RMLINE.getHeight(null) + PADDING;
	} 
	public void paint(Graphics g){
		this.createWindow(g);
		//���ڱ���(����) 
		g.drawImage(Img.POINT, this.x + PADDING, this.y + point_y, null);
		this.drawNumberLeftPad(comX, point_y, this.dto.getNowPoint(), POINT_BIT, g);  
		
		//���ڱ���(����)
		g.drawImage(Img.RMLINE, this.x + PADDING, this.y + rmline_y, null);
		this.drawNumberLeftPad(comX, rmline_y, this.dto.getNowRemoveLine(), POINT_BIT, g);  
		//����ֵ�� (����ֵ)
		int rmLine = this.dto.getNowRemoveLine();
		this.drawRect(expY,"��һ��",null,(double)(rmLine % LEVEL_UP)/(double)LEVEL_UP, g);
		//TODO ��ʱ

	}
	/**
	 * ��ʱ�Ļ�ֵ����ɫ�ķ��������á�
	 * @param hp
	 * @param maxHp
	 * @return
	 */
	@Deprecated
	private Color getNowColor(double hp,double maxHp){
		int colorR = 0;
		int colorG = 255;
		int colorB = 0;
		double hpHalf = maxHp / 2;
		if(hp > hpHalf){
			colorR = 255 - (int)(((hp - hpHalf) / hpHalf) * 255);
			colorG = 255;
		}else{
			colorR = 255;
			colorG = (int)((hp / hpHalf) * 255);
		}
		return new Color(colorR,colorG,colorB);
	}
}
