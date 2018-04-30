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
	 * ����ǩ��
	 */
	public  static  Image SIGN = new ImageIcon("Graphics/string/sign.png").getImage();
	/**
	 * 
	 */
	public  static Image WINDOW = new ImageIcon("Graphics/window/Window.png").getImage();//���ڱ߿��ͼ��
	
	/**
	 * ����ͼƬ 260  36
	 */
	public static Image NUMBER = new ImageIcon("graphics/string/num.png").getImage();
	
	/**
	 * ����ֵ��
	 */
	public static  Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	/**
	 * ���ݿⴰ�ڱ���
	 */
	public  static  Image DB = new ImageIcon("Graphics/string/db.png").getImage();
	/**
	 * ���ؼ�¼���ڱ���
	 */
	public  static  Image DISK = new ImageIcon("Graphics/string/disk.png").getImage();
	/**
	 * ����ͼƬ
	 */
	public  static Image ACT = new ImageIcon("Graphics/game/rect.png").getImage();
	/**
	 * �ȼ�����ͼƬ
	 */
	public static  Image LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	/**
	 * ����ͼƬ��������
	 */
	public static  Image POINT = new ImageIcon("graphics/string/point.png").getImage();

	/**
	 * ����ͼƬ�����У�
	 */
	public static  Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	
	/**
	 * ��Ӱ(����)
	 */
	public static Image SHADOW = new ImageIcon("graphics/game/shadow.png").getImage();
	/**
	 * ��һ��ͼƬ����
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	/**
	 * ��̬���������ã�����ص�ʱ���ʼ����
	 * ���⣬���������������õ�ͼƬֱ���������ķ�ʽ��
	 * ��ͨ��rect.png��ƴ���һ�����飨����LayerGame���ķ�ʽ����ʡCPU��
	 * �����˷�CPU��ƴ���ͼƬ�ķ���ȴ�ǽ�ʡ�ڴ�ģ���ֻ���һ��ͼƬ��
	 * �ۺϿ��ǽ�ʡCPU��ѡ����ã�Ӳ����չ�ĽǶȣ��ռ任ʱ�䡣�ֽ�Ļ����ڴ��CPUȡ��ȡCPU��CPU����ö���ƿ����
	 */
	static{
		//��һ������ͼƬ
		NEXT_ACT = new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("Graphics/game/" + i + ".png").getImage();
		}
		//����ͼƬ����
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
