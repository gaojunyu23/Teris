package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.FrameConfig;
import config.GameConfig;
import dto.GameDto;

public abstract class Layer {
	protected static final int PADDING; //内边距
	protected  static final int BORDER;//窗口边框条的宽度
	static{
		FrameConfig fCfg = GameConfig.getFrameConfig();
		PADDING = fCfg.getPadding();
		BORDER = fCfg.getBorder();
	}
	
	private static final int WINDOW_W = Img.WINDOW.getWidth(null);//窗口边框图案的宽
	private  static final int WINDOW_H = Img.WINDOW.getHeight(null);
	
	/**
	 * 数字切片的宽度
	 */
	protected static final int IMG_NUMBER_W = Img.NUMBER.getWidth(null) / 10;
	/**
	 * 数字切片的高度
	 */
	private static final int IMG_NUMBER_H = Img.NUMBER.getHeight(null);

	/**
	 * 矩形值槽 高度	
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);
	/**
	 * 矩形值槽图片 宽度
	 */
	private static final int IMG_RECT_W = Img.RECT.getWidth(null);
	/**
	 * 矩形值槽 宽度
	 */
	private final int rectW ;
	/**
	 * 默认字体    加上这里之后游戏启动变慢，原因未找到。。。。。
	 */
	private static final Font DEF_FONT = new Font("黑体",Font.ITALIC,20);

	
	/**
	 * 窗口左上角X坐标
	 * */
	protected int x;
	/**
	 * 窗口左上角Y坐标
	 * */
	protected int y;
	/**
	 * 窗口宽度
	 * */
	protected int w;
	/**
	 * 窗口高度
	 * */
	protected int h;
	
	protected GameDto dto = null;
	protected Layer(int x,int y,int w,int h){//构造器这快用protected的话，和private差不多  在外部除子类就不能实例化了
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rectW = this.w - (PADDING << 1);
	}
	protected void createWindow(Graphics g){//绘制窗口的方法（绘制的窗口根据实际的参数值有不同的位置和大小）
		//左上
		g.drawImage(Img.WINDOW, x, y, x+BORDER, y+BORDER, 0, 0, BORDER, BORDER, null);
		//中上
		g.drawImage(Img.WINDOW, x+BORDER, y, x+w-BORDER, y+BORDER, BORDER, 0, WINDOW_W-BORDER, BORDER, null);
		//右上
		g.drawImage(Img.WINDOW, x+w-BORDER, y, x+w, y+BORDER, WINDOW_W-BORDER, 0, WINDOW_W, BORDER, null);
		//左中
		g.drawImage(Img.WINDOW, x, y+BORDER, x+BORDER, y+h-BORDER, 0, BORDER, BORDER, WINDOW_H-BORDER, null);
		//中
		g.drawImage(Img.WINDOW, x+BORDER, y+BORDER, x+w-BORDER, y+h-BORDER, BORDER, BORDER, WINDOW_W-BORDER, WINDOW_H-BORDER, null);
		//右中
		g.drawImage(Img.WINDOW, x+w-BORDER, y+BORDER, x+w, y+h-BORDER, WINDOW_W-BORDER, BORDER, WINDOW_W, WINDOW_H-BORDER, null);
		//左下
		g.drawImage(Img.WINDOW, x, y+h-BORDER, x+BORDER, y+h, 0, WINDOW_H-BORDER, BORDER, WINDOW_H, null);
		//中下
		g.drawImage(Img.WINDOW, x+BORDER, y+h-BORDER, x+w-BORDER, y+h, BORDER, WINDOW_H-BORDER, WINDOW_W-BORDER, WINDOW_H, null);
		//右下
		g.drawImage(Img.WINDOW, x+w-BORDER, y+h-BORDER, x+w, y+h, WINDOW_W-BORDER, WINDOW_H-BORDER, WINDOW_W, WINDOW_H, null);
	}
	/**
	 * 设置游戏数据对象
	 * @param dto
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * 显示数字(右对齐：leftpad左填充)
	 * @param x 左上角X坐标
	 * @param y 左上角Y坐标
	 * @param num 要显示的数字
	 * @param maxBit 数字位数
	 * @param g 画笔对象
	 */
	protected void drawNumberLeftPad(int x,int y,int num, int maxBit,Graphics g){
		//把要打印的数字转换成字符串
		String strNum = Integer.toString(num);
		//循环绘制数字右
		for (int i = 0; i < maxBit; i++) {
			//判断是否满足绘制条件
			if(maxBit - i <= strNum.length()){         //实现左填充，不满足的跳过，下面就不画它
				//获得数字在字符串中的下标
				int idx = i - maxBit + strNum.length();   //idx从0起步 
				//把数字的每一位取出
				int bit = strNum.charAt(idx) - '0';
				//绘制数字
				g.drawImage(Img.NUMBER, 
						this.x + x + IMG_NUMBER_W * i, this.y + y, 
						this.x + x + IMG_NUMBER_W * (i+1), this.y + y +IMG_NUMBER_H, 
						bit * IMG_NUMBER_W, 0, 
						(bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
			}
		}
	}
	
	/**
	 * 绘制值槽
	 * @param title
	 * @param number
	 * @param value
	 * @param maxValue
	 * @param g
	 */
	protected void drawRect(int y,String title,String number,double percent,Graphics g){
		//各种值初始化
		int rect_x = this.x + PADDING;
		int rect_y = this.y + y;
		//绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);
		//绘制值槽
		//求出宽度
		int w = (int)( percent * (this.rectW - 4) );
		//求出颜色
		int subIdx = (int)(percent * IMG_RECT_W - 1);
		g.drawImage(Img.RECT , 
				rect_x + 2, rect_y + 2,
				rect_x + 2 + w, rect_y + 2 + IMG_RECT_H, 
				subIdx, 0, subIdx + 1, IMG_RECT_H,
				null);
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x + 4, rect_y + 22);
		if(number != null){
			g.drawString(number, rect_x + 232, rect_y + 22);
			
		}
	} 
	
	/**
	 * 
	 * 正中绘图
	 */
	protected void drawImageAtCenter(Image img,Graphics g){
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
	}
	
	/**
	 * 刷新游戏具体内容
	 * @param g
	 */
	public abstract void paint(Graphics g);
	/*抽象方法肯定是子类来实现；但是以前一直没多想，其实如果这里不写这个方法，而只在子类中新写一个PAINT没什么问题，
	 * 但问题是如果用到数组的时候，比如：lays = new Layer[]{XXXX... ...}这时候JAVA看到Lay[]它就很二逼的不往下看，
	 * 只到Layer这个父类中来找paint方法，结果找不到，就报错了~所以我才在这里写这么个抽象方法给以后子类实现去
	 * */
}
