package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;

public class JPanelGame extends JPanel{
	
	private Layer[] lays = null;
	
	//存放各窗体对象实例
	private List<Layer> layers = new ArrayList<Layer>();
	
	public JPanelGame() {
		try {
			GameConfig gameConfig = ConfigFactory.getGameConfig();
			//获取已配置好的各窗体参数值，将通过反射创建各窗体对象实例
			List<LayerConfig> layerConfigs = gameConfig.getLayerConfigs();
			for (LayerConfig layerConfig : layerConfigs) {
				Class<?> cls = Class.forName(layerConfig.getClassName());
				Constructor<?> constructor = cls.getConstructor(int.class,int.class,int.class,int.class);
				Layer layer = (Layer) constructor.newInstance(layerConfig.getX(),layerConfig.getY(),layerConfig.getW(),layerConfig.getH());
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < layers.size(); i++) {
			layers.get(i).paint(g);
		}
		
	}
	
}
