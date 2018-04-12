package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	
	/**
	 * 游戏窗口宽度
	 */
	private int width;
	/**
	 * 游戏窗口高度
	 */
	private int height;
	/**
	 * 各窗口内文字与窗口边界距离
	 */
	private int padding;
	/**
	 * 窗体框线粗度
	 */
	private int border;
	
	/**
	 *游戏窗口标题 
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
		//设置游戏窗口界面参数
		this.getUiConfig(frame);
		//设置系统参数
		this.getSystemConfig(game.element("system"));
		//设置数据访问参数
		this.getDataConfig(game.element("data"));
	}
	
	/**
	 * 获取游戏窗口参数值
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
	 * 获取系统参数值
	 * @param system
	 */
	public void getSystemConfig(Element system) {
		//TODO
	}
	
	/**
	 * 获取数据访问参数值
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
