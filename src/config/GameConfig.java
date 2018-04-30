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
			//����XML��ȡ��
			SAXReader read = new SAXReader();
			//��ȡXML�ļ�
			Document doc = read.read("config/cfg.xml");
			//���XML�ļ��ĸ��ڵ�
			Element game = doc.getRootElement();
			//�����������ö���
			FRAME_CONFIG = new FrameConfig(game.element("frame"));
			//����ϵͳ����
			SYSTEM_CONFIG = new SystemConfig(game.element("system"));
			//�������ݷ������ö���
			DATA_CONFIG = new DataConfig(game.element("data"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ������˽�л�
	 */
	private GameConfig(){
		
	}
	/**
	 * ������ݷ�������
	 * @return
	 */
	public static DataConfig getDataConfig(){
		return DATA_CONFIG;
	}
	/**
	 * ��ô�������
	 * @return
	 */
	public static FrameConfig getFrameConfig(){
		return FRAME_CONFIG;
	}
	/**
	 * ���ϵͳ����
	 * @return
	 */
	public static SystemConfig getSystemConfig(){
		return SYSTEM_CONFIG;
	}
}
