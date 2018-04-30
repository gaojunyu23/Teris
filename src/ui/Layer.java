package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.FrameConfig;
import config.GameConfig;
import dto.GameDto;

public abstract class Layer {
	protected static final int PADDING; //�ڱ߾�
	protected  static final int BORDER;//���ڱ߿����Ŀ��
	static{
		FrameConfig fCfg = GameConfig.getFrameConfig();
		PADDING = fCfg.getPadding();
		BORDER = fCfg.getBorder();
	}
	
	private static final int WINDOW_W = Img.WINDOW.getWidth(null);//���ڱ߿�ͼ���Ŀ�
	private  static final int WINDOW_H = Img.WINDOW.getHeight(null);
	
	/**
	 * ������Ƭ�Ŀ��
	 */
	protected static final int IMG_NUMBER_W = Img.NUMBER.getWidth(null) / 10;
	/**
	 * ������Ƭ�ĸ߶�
	 */
	private static final int IMG_NUMBER_H = Img.NUMBER.getHeight(null);

	/**
	 * ����ֵ�� �߶�	
	 */
	protected static final int IMG_RECT_H = Img.RECT.getHeight(null);
	/**
	 * ����ֵ��ͼƬ ���
	 */
	private static final int IMG_RECT_W = Img.RECT.getWidth(null);
	/**
	 * ����ֵ�� ���
	 */
	private final int rectW ;
	/**
	 * Ĭ������    ��������֮����Ϸ����������ԭ��δ�ҵ�����������
	 */
	private static final Font DEF_FONT = new Font("����",Font.ITALIC,20);

	
	/**
	 * �������Ͻ�X����
	 * */
	protected int x;
	/**
	 * �������Ͻ�Y����
	 * */
	protected int y;
	/**
	 * ���ڿ��
	 * */
	protected int w;
	/**
	 * ���ڸ߶�
	 * */
	protected int h;
	
	protected GameDto dto = null;
	protected Layer(int x,int y,int w,int h){//�����������protected�Ļ�����private���  ���ⲿ������Ͳ���ʵ������
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rectW = this.w - (PADDING << 1);
	}
	protected void createWindow(Graphics g){//���ƴ��ڵķ��������ƵĴ��ڸ���ʵ�ʵĲ���ֵ�в�ͬ��λ�úʹ�С��
		//����
		g.drawImage(Img.WINDOW, x, y, x+BORDER, y+BORDER, 0, 0, BORDER, BORDER, null);
		//����
		g.drawImage(Img.WINDOW, x+BORDER, y, x+w-BORDER, y+BORDER, BORDER, 0, WINDOW_W-BORDER, BORDER, null);
		//����
		g.drawImage(Img.WINDOW, x+w-BORDER, y, x+w, y+BORDER, WINDOW_W-BORDER, 0, WINDOW_W, BORDER, null);
		//����
		g.drawImage(Img.WINDOW, x, y+BORDER, x+BORDER, y+h-BORDER, 0, BORDER, BORDER, WINDOW_H-BORDER, null);
		//��
		g.drawImage(Img.WINDOW, x+BORDER, y+BORDER, x+w-BORDER, y+h-BORDER, BORDER, BORDER, WINDOW_W-BORDER, WINDOW_H-BORDER, null);
		//����
		g.drawImage(Img.WINDOW, x+w-BORDER, y+BORDER, x+w, y+h-BORDER, WINDOW_W-BORDER, BORDER, WINDOW_W, WINDOW_H-BORDER, null);
		//����
		g.drawImage(Img.WINDOW, x, y+h-BORDER, x+BORDER, y+h, 0, WINDOW_H-BORDER, BORDER, WINDOW_H, null);
		//����
		g.drawImage(Img.WINDOW, x+BORDER, y+h-BORDER, x+w-BORDER, y+h, BORDER, WINDOW_H-BORDER, WINDOW_W-BORDER, WINDOW_H, null);
		//����
		g.drawImage(Img.WINDOW, x+w-BORDER, y+h-BORDER, x+w, y+h, WINDOW_W-BORDER, WINDOW_H-BORDER, WINDOW_W, WINDOW_H, null);
	}
	/**
	 * ������Ϸ���ݶ���
	 * @param dto
	 */
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * ��ʾ����(�Ҷ��룺leftpad�����)
	 * @param x ���Ͻ�X����
	 * @param y ���Ͻ�Y����
	 * @param num Ҫ��ʾ������
	 * @param maxBit ����λ��
	 * @param g ���ʶ���
	 */
	protected void drawNumberLeftPad(int x,int y,int num, int maxBit,Graphics g){
		//��Ҫ��ӡ������ת�����ַ���
		String strNum = Integer.toString(num);
		//ѭ������������
		for (int i = 0; i < maxBit; i++) {
			//�ж��Ƿ������������
			if(maxBit - i <= strNum.length()){         //ʵ������䣬�����������������Ͳ�����
				//����������ַ����е��±�
				int idx = i - maxBit + strNum.length();   //idx��0�� 
				//�����ֵ�ÿһλȡ��
				int bit = strNum.charAt(idx) - '0';
				//��������
				g.drawImage(Img.NUMBER, 
						this.x + x + IMG_NUMBER_W * i, this.y + y, 
						this.x + x + IMG_NUMBER_W * (i+1), this.y + y +IMG_NUMBER_H, 
						bit * IMG_NUMBER_W, 0, 
						(bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null);
			}
		}
	}
	
	/**
	 * ����ֵ��
	 * @param title
	 * @param number
	 * @param value
	 * @param maxValue
	 * @param g
	 */
	protected void drawRect(int y,String title,String number,double percent,Graphics g){
		//����ֵ��ʼ��
		int rect_x = this.x + PADDING;
		int rect_y = this.y + y;
		//���Ʊ���
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H + 4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 1, rect_y + 1, this.rectW - 2, IMG_RECT_H + 2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4, IMG_RECT_H);
		//����ֵ��
		//������
		int w = (int)( percent * (this.rectW - 4) );
		//�����ɫ
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
	 * ���л�ͼ
	 */
	protected void drawImageAtCenter(Image img,Graphics g){
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
	}
	
	/**
	 * ˢ����Ϸ��������
	 * @param g
	 */
	public abstract void paint(Graphics g);
	/*���󷽷��϶���������ʵ�֣�������ǰһֱû���룬��ʵ������ﲻд�����������ֻ����������дһ��PAINTûʲô���⣬
	 * ������������õ������ʱ�򣬱��磺lays = new Layer[]{XXXX... ...}��ʱ��JAVA����Lay[]���ͺܶ��ƵĲ����¿���
	 * ֻ��Layer�������������paint����������Ҳ������ͱ�����~�����Ҳ�������д��ô�����󷽷����Ժ�����ʵ��ȥ
	 * */
}
