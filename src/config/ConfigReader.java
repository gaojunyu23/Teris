package config;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 测试
 * @author 高君宇
 *
 */
public class ConfigReader {
	public static void readConfig() throws Exception{
		SAXReader read = new SAXReader();//XML读取器
		Document doc = read.read("config/cfg.xml");//读取XML配置文件，以得到节点元素
		Element game = doc.getRootElement();
		Element frame = game.element("frame");
		List<Element> layers = frame.elements("layer");
		String str = frame.attributeValue("height");
		System.out.println(str);
		for(Element layer:layers){
			System.out.print(layer.attributeValue("className")+",");
			System.out.print(layer.attributeValue("x")+",");
			System.out.print(layer.attributeValue("y")+",");
			System.out.print(layer.attributeValue("w")+",");
			System.out.print(layer.attributeValue("h")+",");
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		readConfig();
	}
}
