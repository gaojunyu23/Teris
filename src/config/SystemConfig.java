package config;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class SystemConfig {
	private final int minX;
	
	private final int maxX;
	
	private final int minY;
	
	private final int maxY;
	
	private final int levelUp;
	
	private final List<Point[]> typeConfig;
	
	
	public SystemConfig(Element system){
		this.minX = Integer.parseInt(system.attributeValue("minX"));
		this.maxX = Integer.parseInt(system.attributeValue("maxX"));
		this.minY = Integer.parseInt(system.attributeValue("minY"));
		this.maxY = Integer.parseInt(system.attributeValue("maxY"));
		this.levelUp = Integer.parseInt(system.attributeValue("levelUp"));
		
		List<Element> rects = system.elements("rect");
		typeConfig = new ArrayList(rects.size());
		for (Element rect : rects) {
			List<Element> pointConfig = rect.elements("point");
			//创建Point对象数组
			Point[] points = new Point[pointConfig.size()];
			//初始化Point对象数组
			for (int i = 0; i < points.length; i++) {
				int x = Integer.parseInt(pointConfig.get(i).attributeValue("x"));
				int y = Integer.parseInt(pointConfig.get(i).attributeValue("y"));
				points[i] = new Point(x,y);
			}
			typeConfig.add(points);
		}
	}

	public int getMinX() {
		return minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxY() {
		return maxY;
	}

	public List<Point[]> getTypeConfig() {
		return typeConfig;
	}

	public int getLevelUp() {
		return levelUp;
	}
	
}
