package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public FileInputStream fis;
	public Properties p;
	public ReadConfig() {
	try {
		fis = new FileInputStream("src/test/resources/config.properties");
		p = new Properties();
		p.load(fis);
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	public String browser() {
		String browser = p.getProperty("browser");
		return browser;
	}
	public String url() {
		String url = p.getProperty("url");
		return url;
	}
	
	
	
}
