package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import config.GameConfig;

public class Img {
	public Img(){}
	/**
	 * 个人签名
	 */
	public  static  Image SIGN = new ImageIcon("Graphics/string/sign.png").getImage();
	/**
	 * 
	 */
	public  static Image WINDOW = new ImageIcon("Graphics/window/Window.png").getImage();//窗口边框的图案
	
	/**
	 * 数字图片 260  36
	 */
	public static Image NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	
	/**
	 * 矩形值槽
	 */
	public static  Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	/**
	 * 数据库窗口标题
	 */
	public  static  Image DB = new ImageIcon("Graphics/string/db.png").getImage();
	/**
	 * 本地记录窗口标题
	 */
	public  static  Image DISK = new ImageIcon("Graphics/string/disk.png").getImage();
	/**
	 * 方块图片
	 */
	public  static Image ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	/**
	 * 等级标题图片
	 */
	public static  Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	/**
	 * 标题图片（分数）
	 */
	public static  Image POINT = new ImageIcon("graphics/string/point.png").getImage();

	/**
	 * 标题图片（消行）
	 */
	public static  Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	
	/**
	 * 阴影(消行)
	 */
	public static Image SHADOW = new ImageIcon("graphics/game/shadow.png").getImage();
	/**
	 * 下一个图片数组
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	/**
	 * 静态代码块的作用：类加载的时候初始化。
	 * 另外，下面这种用制作好的图片直接贴过来的方式，
	 * 与通过rect.png来拼算出一个方块（参照LayerGame）的方式更节省CPU；
	 * 不过浪费CPU的拼算出图片的方法却是节省内存的（因只需存一张图片）
	 * 综合考虑节省CPU的选择更好（硬件发展的角度：空间换时间。现今的机器内存和CPU取舍取CPU，CPU运算得多有瓶颈）
	 */
	static{
		//下一个方块图片
		NEXT_ACT = new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("Graphics/game/" + i + ".png").getImage();
		}
		//背景图片数组
		File dir = new File("Graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<Image>();
		for(File file : files){
			if(file.isDirectory()){
				continue;
			}
			BG_LIST.add(new ImageIcon(file.getPath()).getImage());

		}
	}
	
}
