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
	By radius = By.name("radius");
	By make = By.name("make");
	By model = By.name("model");
	By maxPrice = By.name("price-to");
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
	public void selectRadius() {
		Select oSelect = new Select(driver.findElement(radius));
		oSelect.selectByValue("100");
	}
	public String getRadius() {
		return driver.findElement(radius).getText();
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
	public void selectMaxPrice() {
		Select oSelect = new Select(driver.findElement(maxPrice));
		oSelect.selectByValue("100000");
	}
	public String getMaxPrice() {
		return driver.findElement(maxPrice).getText();
	}
	public void clickSearch(){
		driver.findElement(searchBTN).click();
	}
}