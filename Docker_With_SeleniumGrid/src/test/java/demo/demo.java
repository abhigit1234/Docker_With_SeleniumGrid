package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demo {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("abhilash");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("naidu");
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("hyderabad");
		driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("naidu@hmail.com");
		driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("9890989876");
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement rad : radio) {
			if (rad.getAttribute("value").equals("Male")) {
				rad.click();
			}
		}
		List<WebElement> hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for (WebElement hob : hobbies) {
			if (hob.getAttribute("value").equals("Hockey")) {
				hob.click();
			}
		}

		driver.findElement(By.id("msdd")).click();
		
		List<WebElement> languages = driver.findElements(By.xpath("//li[@class='ng-scope']/a"));
		getReqValues("Dutch", languages);
		getReqValues("Japanese", languages);
		getReqValues("Persian", languages);
		getReqValues("Malay", languages);

		WebElement skills = driver.findElement(By.id("Skills"));
		getSelect("Java", skills);

		driver.findElement(By.xpath("//span[@role='combobox']")).click();
		List<WebElement> country = driver.findElements(By.xpath("//ul[@role='tree']/li"));
		getReqValues("United States of America", country);
		
		WebElement year =	driver.findElement(By.xpath("//select[@id='yearbox']"));
		WebElement month =	driver.findElement(By.xpath("//select[@placeholder='Month']"));
		WebElement day =	driver.findElement(By.xpath("//select[@id='daybox']"));
		
		getSelect("1989", year);
		getSelect("November", month);
		getSelect("25", day);
		
		driver.findElement(By.id("firstpassword")).sendKeys("abhilash123");
		driver.findElement(By.id("secondpassword")).sendKeys("abhilash123");
		driver.findElement(By.id("submitbtn")).click();
		System.out.println(driver.getTitle());
		driver.close();
	}

	public static String getReqValues(String val, List<WebElement> reqValues) {

		for (WebElement lan : reqValues) {
			if (lan.getText().equals(val)) {
				lan.click();
			}
		}
		return val;
	}

	public static String getSelect(String val, WebElement e) {
		Select s = new Select(e);
		List<WebElement> skills = s.getOptions();
		for (WebElement skill : skills) {
			if (skill.getText().equals(val)) {
				skill.click();
			}
		}
		return val;

	}
}
