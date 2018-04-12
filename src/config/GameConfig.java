package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	
	/**
	 * ��Ϸ���ڿ��
	 */
	private int width;
	/**
	 * ��Ϸ���ڸ߶�
	 */
	private int height;
	/**
	 * �������������봰�ڱ߽����
	 */
	private int padding;
	/**
	 * ������ߴֶ�
	 */
	private int border;
	
	/**
	 *��Ϸ���ڱ��� 
	 */
	private String title;

	private List<LayerConfig> layerConfigs = new ArrayList<LayerConfig>();
	
	public GameConfig() throws Exception {
		SAXReader reader = new SAXReader();
		Document doc = reader.read("config/cfg.xml");
		Element game = doc.getRootElement();
		Element frame = game.element("frame");
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		this.border = Integer.parseInt(frame.attributeValue("border"));
		this.title = frame.attributeValue("title");
		//������Ϸ���ڽ������
		this.getUiConfig(frame);
		//����ϵͳ����
		this.getSystemConfig(game.element("system"));
		//�������ݷ��ʲ���
		this.getDataConfig(game.element("data"));
	}
	
	/**
	 * ��ȡ��Ϸ���ڲ���ֵ
	 * @param frame
	 */
	public void getUiConfig(Element frame) {
		List<Element>layers = frame.elements();
		for (Element layerConfig : layers) {
			LayerConfig lc = new LayerConfig(layerConfig.attributeValue("className"),
					Integer.parseInt(layerConfig.attributeValue("x")),
					Integer.parseInt(layerConfig.attributeValue("y")),
					Integer.parseInt(layerConfig.attributeValue("w")),
					Integer.parseInt(layerConfig.attributeValue("h")));

			layerConfigs.add(lc);
		}
	}
	
	/**
	 * ��ȡϵͳ����ֵ
	 * @param system
	 */
	public void getSystemConfig(Element system) {
		//TODO
	}
	
	/**
	 * ��ȡ���ݷ��ʲ���ֵ
	 * @param date
	 */
	public void getDataConfig(Element date) {
		//TODO
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPadding() {
		return padding;
	}

	public int getBorder() {
		return border;
	}

	public List<LayerConfig> getLayerConfigs() {
		return layerConfigs;
	}
	
	public String getTitle() {
		return title;
	}
	
}
