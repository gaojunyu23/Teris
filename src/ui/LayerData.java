package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import config.GameConfig;

import dto.Player;

public abstract class LayerData extends Layer{
	/**
	 * 最大数据行
	 */
	private static final int MAX_ROW = GameConfig.getDataConfig().getMaxRow(); 	
	
	/**
	 * 起始Y坐标
	 */
	private static  int START_Y = 0;
	/**
	 * 值槽外径
	 */
	private static final int RECT_H = IMG_RECT_H + 4;

	/**
	 * 间距
	 */
	private static  int SPA = 0;
	
	protected LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		//计算记录绘制间距
		SPA = (this.h - (IMG_RECT_H + 4) * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW; //20接口5'46''
		//计算起始Y坐标
		START_Y = PADDING + Img.DB.getHeight(null) + SPA;
	}
	
	/**
	 * 绘制该窗口所有值槽
	 * @param imgTitle 标题图片
	 * @param players  数据源
	 * @param g 画笔
	 */
	public void showData(Image imgTitle,List<Player> players,Graphics g){
		//绘制标题
		g.drawImage(imgTitle, this.x + PADDING, this.y + PADDING, null);

		//获得现在分数
		int nowPoint = this.dto.getNowPoint();
		//循环绘制记录
		for (int i = 0; i < MAX_ROW; i++) {
			//获得一条玩家记录
			Player pla = players.get(i);
			//获得该分数
			int recodePoint = pla.getPoint();
			//计算现在分数与记录分数比值
			double percent = (double)nowPoint / recodePoint;
			//如果已经破纪录,比值设为100%
			percent = percent > 1 ? 1.0 : percent;
			//绘制单条记录
			String strPoint = recodePoint == 0 ? null : Integer.toString(recodePoint);
			this.drawRect(START_Y + i * (RECT_H + SPA), 
					pla.getName(), strPoint, 
					percent , g);
		}
	}
	
	@Override
    public abstract void paint(Graphics g);

}
