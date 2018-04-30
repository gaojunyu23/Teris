package config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	private static FrameConfig FRAME_CONFIG = null;
	private static DataConfig DATA_CONFIG = null;
	private static SystemConfig SYSTEM_CONFIG = null;
	
	static{
		try {
			//创建XML读取器
			SAXReader read = new SAXReader();
			//读取XML文件
			Document doc = read.read("config/cfg.xml");
			//获得XML文件的根节点
			Element game = doc.getRootElement();
			//创建界面配置对象
			FRAME_CONFIG = new FrameConfig(game.element("frame"));
			//创建系统对象
			SYSTEM_CONFIG = new SystemConfig(game.element("system"));
			//创建数据访问配置对象
			DATA_CONFIG = new DataConfig(game.element("data"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 构造器私有化
	 */
	private GameConfig(){
		
	}
	/**
	 * 获得数据访问配置
	 * @return
	 */
	public static DataConfig getDataConfig(){
		return DATA_CONFIG;
	}
	/**
	 * 获得窗口配置
	 * @return
	 */
	public static FrameConfig getFrameConfig(){
		return FRAME_CONFIG;
	}
	/**
	 * 获得系统配置
	 * @return
	 */
	public static SystemConfig getSystemConfig(){
		return SYSTEM_CONFIG;
	}
}
