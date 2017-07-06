package autotrader.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	WebDriver driver;
	
	By postcode = By.name("postcode");
	By make = By.name("make");
	By model = By.name("model");
	By continueBTN = By.id("postcode-lightbox-continue");
	By searchBTN = By.name("search-used-vehicles");
	
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
	public void selectMake() {
		Select oSelect = new Select(driver.findElement(make));
		oSelect.selectByValue("TESLA");
	}
	public String getMake() {
		return driver.findElement(make).getText();
	}
	public void selectModel() {
		Select oSelect = new Select(driver.findElement(model));
		oSelect.selectByValue("MODEL X");
	}
	public String getModel() {
		return driver.findElement(model).getText();
	}
	
	public void clickSearch(){
		driver.findElement(searchBTN).click();
	}
}