package ui;

import java.awt.Color;
import java.awt.Graphics;

import config.GameConfig;

public class LayerPoint extends Layer {
	/**
	 * 分数最大位数
	 */
	private static final int POINT_BIT = 5;
	/**
	 * 升级行数 
	 */
	private static final int LEVEL_UP = GameConfig.getSystemConfig().getLevelUp();
	
	/**
	 * "消行"Y坐标
	 */
	private  final int rmline_y ;
	
	/**
	 * "分数"Y坐标
	 */
	private  final int point_y; 
	
	/**
	 * 经验值Y坐标
	 */
	private final int expY;

	/**
	 * "消行"及"分数"共同的X坐标
	 */
	private final int comX;
	
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		//初始化共通的X坐标
		this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING ;
		//初始化分数的Y坐标
		this.point_y = PADDING; 
		//初始化 "消行"Y坐标
		this.rmline_y = point_y + Img.POINT.getHeight(null) + PADDING ;

		//初始化经验值的Y坐标
		this.expY = rmline_y +  Img.RMLINE.getHeight(null) + PADDING;
	} 
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题(分数) 
		g.drawImage(Img.POINT, this.x + PADDING, this.y + point_y, null);
		this.drawNumberLeftPad(comX, point_y, this.dto.getNowPoint(), POINT_BIT, g);  
		
		//窗口标题(消行)
		g.drawImage(Img.RMLINE, this.x + PADDING, this.y + rmline_y, null);
		this.drawNumberLeftPad(comX, rmline_y, this.dto.getNowRemoveLine(), POINT_BIT, g);  
		//绘制值槽 (经验值)
		int rmLine = this.dto.getNowRemoveLine();
		this.drawRect(expY,"下一级",null,(double)(rmLine % LEVEL_UP)/(double)LEVEL_UP, g);
		//TODO 临时

	}
	/**
	 * 过时的画值槽颜色的方法，弃用。
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
