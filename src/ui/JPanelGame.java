package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel{
	
	private Layer[] lays = null;
	
	private GameDto gameDto;

	//��Ÿ��������ʵ��
	private List<Layer> layers = new ArrayList<Layer>();
	
	public JPanelGame(GameDto dto) {
		this.gameDto = dto;
		
		initComponent();
		
		initPlayer();
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		
	}
	
	/**
	 * ��װ��Ϸ��ҿ�����
	 * @param playerControl
	 */
	public void setPlayerControl(PlayerControl playerControl) {
		this.addKeyListener(playerControl);
	}
	/**
	 * ��ʼ����
	 */
	private void initPlayer() {
		try {
			GameConfig gameConfig = ConfigFactory.getGameConfig();
			//��ȡ�����úõĸ��������ֵ����ͨ�����䴴�����������ʵ��
			List<LayerConfig> layerConfigs = gameConfig.getLayerConfigs();
			for (LayerConfig layerConfig : layerConfigs) {
				Class<?> cls = Class.forName(layerConfig.getClassName());
				Constructor<?> constructor = cls.getConstructor(int.class,int.class,int.class,int.class);
				Layer layer = (Layer) constructor.newInstance(layerConfig.getX(),layerConfig.getY(),layerConfig.getW(),layerConfig.getH());
				layer.setDto(gameDto);
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < layers.size(); i++) {
			layers.get(i).paint(g);
		}
		this.requestFocus();
	}
	

}
