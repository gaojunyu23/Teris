package config;

public class ConfigFactory {
	
	private static GameConfig gameConfig;
	
	public static GameConfig getGameConfig() {
		return gameConfig;
	}

	static {
		try {
			gameConfig = new GameConfig();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
