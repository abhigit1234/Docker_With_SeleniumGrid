package PageObjectClass;

import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjRegister extends PageObjBase {

	public PageObjRegister(ThreadLocal<WebDriver> driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement lnkFirstName;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lnkLastName;
	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	WebElement lnkAddress;
	@FindBy(xpath = "//input[@ng-model='EmailAdress']")
	WebElement lnkEmail;
	@FindBy(xpath = "//input[@ng-model='Phone']")
	WebElement lnkPhone;

	@FindBy(xpath = "//input[@type='radio']")
	List<WebElement> lnkRadio;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> lnkHobbies;

	@FindBy(id = "msdd")
	WebElement lnkLang;

	@FindBy(xpath = "//li[@class='ng-scope']/a")
	List<WebElement> lnkLanguages;
	
	@FindBy(xpath = "//label[text()='Languages']")
	WebElement lnkClickLanguageLabel;
	
	@FindBy(id = "Skills")
	WebElement lnkSkill;

	@FindBy(xpath = "//span[@aria-labelledby='select2-country-container']")
	WebElement clickSelectCountry;

	@FindBy(xpath = "//ul[@role='tree']/li")
	List<WebElement> lnkCountries;

	@FindBy(xpath = "//select[@id='yearbox']")
	WebElement lnkYear;
	@FindBy(xpath = "//select[@placeholder='Month']")
	WebElement lnkMonth;
	@FindBy(xpath = "//select[@id='daybox']")
	WebElement lnkDay;

	@FindBy(id = "firstpassword")
	WebElement lnkPassword;
	@FindBy(id = "secondpassword")
	WebElement lnkConfirmPswd;
	@FindBy(id = "submitbtn")
	WebElement lnkSubmitClick;

	public void setFname(String fn) {
		lnkFirstName.sendKeys(fn);
	}

	public void setLname(String ln) {
		lnkLastName.sendKeys(ln);
	}

	public void setAddress(String add) {
		lnkAddress.sendKeys(add);
	}

	public void setEmail(String e) {
		lnkEmail.sendKeys(e);
	}

	public void setPhone(int num) {
		lnkPhone.sendKeys(String.valueOf(num));
	}

	public String setGender(String val) {
		for (WebElement rad : lnkRadio) {
			if (rad.getAttribute("value").equals(val)) {
				rad.click();
			}
		}
		return val;
	}

	public String setHobbies(String val) {
		for (WebElement hobbies : lnkHobbies) {
			if (hobbies.getAttribute("value").equals(val)) {
				hobbies.click();
			}
		}
		return val;
	}

	public void clickLanguage() {
		lnkLang.click();
	}

	public void setLanguages(String v1, String v2, String v3) {
		for (WebElement language : lnkLanguages) {
			if (language.getText().equals(v1)) {
				((JavascriptExecutor)driver.get()).executeScript("arguments[0].click()",language);
			}
			if (language.getText().equals(v2)) {
				((JavascriptExecutor)driver.get()).executeScript("arguments[0].click()",language);
			}
			if (language.getText().equals(v3)) {
				((JavascriptExecutor)driver.get()).executeScript("arguments[0].click()",language);
			}
			
		}

	}
	
	public void clickLanLabel() {
		lnkClickLanguageLabel.click();
	}
	
	public void setSkills(String skills) {
		lnkSkill.sendKeys(skills);
		
	}

	public void clickSelectCountry() {
		clickSelectCountry.click();
	}

	public String setCountry(String country) {
		for (WebElement ele : lnkCountries) {
				
				if (ele.getText().equals(country)) {
					ele.click();
					break;
				}	
		}
		return country;
	}

	public void setYear(String y) {
		select(y, lnkYear);

	}

	public void setMonth(String m) {
		select(m, lnkMonth);

	}

	public void setDay(String d) {
		select(d, lnkDay);

	}

	public String setPassword(String p) {
		lnkPassword.sendKeys(p);
		return p;
	}

	public String setConfirmPassword(String cp) {
		lnkConfirmPswd.sendKeys(cp);
		return cp;
	}

	public void clickSubmit() {

		((JavascriptExecutor)driver.get()).executeScript("arguments[0].click()",lnkSubmitClick);

	}

	public String title() {
		System.out.println(driver.get().getTitle());
		return null;
	}

	public String select(String val, WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> e = s.getOptions();
		for (WebElement el : e) {
			if (el.getText().equals(val)) {
				((JavascriptExecutor)driver.get()).executeScript("arguments[0].click()",el);
			}
		}
		return val;

	}

}