package TestClass;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.BasePage;
import PageObjectClass.PageObjRegister;
import Utilities.ExcelDataProvider;

public class TestMethod extends BasePage{

	@Test
	public void test() throws Exception{
		System.out.println("thread : "+Thread.currentThread().threadId());
		
		  PageObjRegister pom = new PageObjRegister(driver); 
		  pom.setFname("abhilash");
		  pom.setLname("babu");
		  pom.setAddress("hyd malkajgiri");
		  pom.setEmail("abhilashnaidu@123.com");
		  pom.setPhone(1237676767);		  
		  pom.setGender("Male");
		  pom.setHobbies("Hockey");
		  pom.clickLanguage();
		  pom.setLanguages("Czech","Dutch","Portuguese");
		  pom.clickLanLabel();
		  pom.setSkills("MySQL");
		  pom.clickSelectCountry();
		  Thread.sleep(2000);
		  pom.setCountry("New Zealand");
		  pom.setYear("1989");
		  pom.setMonth("March");
		  pom.setDay("22");
		  pom.setPassword("naidu123");
		  pom.setConfirmPassword("iik1i1ll");
		  pom.clickSubmit();
		  pom.title();
		  System.out.println("=== end ===");
	}

	
	  
	  
	/*
	 * @Test public void test() throws Exception{
	 * driver.get().findElement(By.name("q")).sendKeys("sai baba", Keys.ENTER);
	 * Thread.sleep(1000); System.out.println(driver.get().getTitle());
	 * 
	 * }
	 */

}
