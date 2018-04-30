package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.FrameConfig;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerControl;
import dto.GameDto;


public class JPanelGame extends JPanel{

	private static final long serialVersionUID = 1L;

	private List<Layer> layers = null;
	
	private GameDto dto = null;
	
	public JPanelGame(GameDto dto){
		//���dto����
		this.dto = dto;
		//��ʼ�����
		this.initComponent();
		//��ʼ����
		this.initLayer();
	}
	
	/** 
	 * ��װ��ҿ�����
	 * ����main�����б����ã�
	 */
	public void setGameControl(PlayerControl playerControl){
		this.addKeyListener(playerControl);
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		
		
	}
	/**
	 * ��ʼ����
	 */
	private void initLayer(){
		try {
			//�����Ϸ���á��õ�������Ϸ���ã��ѱ��ش��̵������ļ�����������ô��Ǳȴӱ��ش��̶����ݿ졣
			FrameConfig fCfg = GameConfig.getFrameConfig();
			//��ô��ڣ��㣩����
			List<LayerConfig> layersCfg= fCfg.getLayersConfig();
			//������Ϸ������
			layers = new ArrayList<Layer>(layersCfg.size());
			//ѭ�����в����
			for(LayerConfig layerCfg:layersCfg){
				//��������
				Class<?> cls = Class.forName(layerCfg.getClassName());
				//��ù��캯��
				Constructor ctr = cls.getConstructor(int.class,int.class,int.class,int.class);
				//���ù��캯����������
				Layer layer = (Layer)ctr.newInstance(
						layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
				);
				//������Ϸ���ݶ���  
				layer.setDto(dto);
				//�Ѵ�����layer������뼯�ϣ�����֮����Ƴ���Ϸ���档
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	/**
	 * �̳в���д����JPanel�ķ�����û������û�ҵ���������������ﱻ���õ��ˣ�
	 * ���ǲ�д�ֻ��Ʋ�����Ϸ���棡
	 * �������Ĵ��ǣ�
	 * ����java��Ϊ��Ҫ���»��������ʱ����java�Զ����á�
	 * �������ڳ�����ִ��repaint();���߳��򴰿���С����Ȼ��ָ���
	 * ���߳��򴰿ڱ��ڵ��������ֵ�ʱ��
	 * ����ƽ�������ù�����������������ֻ������Ҫ�̳�paintComponent(һ����JFrame)��ʱ����д�������Ϳ����ˡ���
	 * 
	 * ��˼����˵����Ȼ�㿴������������ڳ������ﱻ�����ˣ���ʵ������JAVA�Զ����õģ�JAVA��Ϊ��Ҫ���»������ʱ����
	 * ����ƽ��д����ʱ��ֻ��Ҫ��д���������OK��������׷Ѱ�Ҳ����������ĵ��������������
	 */
	public void paintComponent(Graphics g){
		//���ø��෽��(��ʱû���ֲ�д��ʲôӰ�졣)
		super.paintComponent(g);
		//������Ϸ����
		for(int i=0;i<layers.size();i++){
			layers.get(i).paint(g);
		}
		//���ؽ��㣨��ȡ���㵽��ǰ�ؼ�,Ҳ���������֪����ҵļ��̶������ý��㱣����PANEL�ϣ�����д������û��Ӧ.��
		//��д���ܽ�������PANEL��
		this.requestFocus();
	}
}
