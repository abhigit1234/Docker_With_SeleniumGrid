package BaseClass;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;

public class BasePage extends ReadConfig {

	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@Parameters({ "os", "browser" })
	@BeforeMethod
	public void setup(String os, String browser) throws Exception {

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
				cap.setAcceptInsecureCerts(true);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
				cap.setAcceptInsecureCerts(true);
			} else if (os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
				cap.setAcceptInsecureCerts(true);
			} else {
				System.out.println("no matched os found");
			}
			if (browser.equals("chrome")) {
				cap.setBrowserName("chrome");
				cap.setAcceptInsecureCerts(true);
			} else if (browser.equals("firefox")) {
				cap.setBrowserName("firefox");
				cap.setAcceptInsecureCerts(true);
			} else if (browser.equals("edge")) {
				cap.setBrowserName("MicrosoftEdge");
				cap.setAcceptInsecureCerts(true);
			} else {
				System.out.println("no matching browser found");
			}
			
			driver.set(new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(), cap));
			
		}
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			if (browser.equals("chrome")) {
				driver.set(new ChromeDriver());
			} else if (browser.equals("firefox")) {
				driver.set(new FirefoxDriver());
			} else if (browser.equals("edge")) {
				driver.set(new EdgeDriver());
			}

		}

		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get().get(p.getProperty("url"));
	}

	@AfterMethod
	public void tear() {
		driver.get().close();
		driver.remove();
	}
}
