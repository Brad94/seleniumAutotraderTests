package autotrader.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	WebDriver driver;
	
	By postcode = By.id("postcode");
	
//	By username = By.name("username");
//	By password = By.name("password");
//	By dipLinkHP = By.xpath("//*[@id='course-9']/div[1]/h2/a");
//	By dipLinkEYE = By.xpath("//*[@id='course-8']/div[1]/h2/a");
	
	public Home(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	public void getPostcodeInput(String text) {
		driver.findElement(postcode).sendKeys(text);
	}
	public String getPostcodeTextBoxText() {
		return driver.findElement(postcode).getAttribute("value");
	}
}