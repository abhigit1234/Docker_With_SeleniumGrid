package PageObjectClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjBase {

	public  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public  JavascriptExecutor jse;
	
	
	public PageObjBase(ThreadLocal<WebDriver> driver) {
		this.driver=driver;
		this.jse=(JavascriptExecutor)this.driver.get();
		PageFactory.initElements(driver.get(), this);
	}
}
