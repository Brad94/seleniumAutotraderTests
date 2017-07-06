package autotrader.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import autotrader.tests.pages.*;

public class App 
{
	
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	
	@BeforeClass()
	public void setup(){   
		report = new ExtentReports(
				"C:\\Users\\BjPol\\Documents\\Eclipse\\autotrader\\automationreport.html",true);
		test = report.startTest("Autotrader tests");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\BjPol\\Documents\\Eclipse\\autotrader\\SeleniumFiles\\Selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\BjPol\\Documents\\Eclipse\\autotrader\\SeleniumFiles\\Selenium\\geckodriver.exe");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.get("http://www.autotrader.co.uk/");

		homePage = new Home(driver);
		test.log(LogStatus.INFO, "Browser started");

	}
	@Test(priority = 1, enabled = true)
	public void testTitle() {
		String homePageTitle = homePage.getTitle();
		if (homePageTitle.contains("Auto Trader UK | Find New & Used Cars for Sale")) {
			test.log(LogStatus.PASS, "Verify home page title");
		} else {
			test.log(LogStatus.FAIL, "Verify home page title");
		}
	}
	@Test(priority = 1, enabled = true)
	public void testCarSearchRadius() {
		homePage.selectRadius();
		String radiusText = homePage.getRadius();
		if (radiusText.contains("Within 100 miles")) {
			test.log(LogStatus.PASS, "verify radius input");
		} else {
			test.log(LogStatus.FAIL, "verify radius input");
		}
	}
	@Test(priority = 3, enabled = true)
	public void testCarSearchMake() {
		homePage.selectMake();
		String makeText = homePage.getMake();
		if (makeText.contains("Tesla")) {
			test.log(LogStatus.PASS, "verify make input");
		} else {
			test.log(LogStatus.FAIL, "verify make input");
		}
	}
	@Test(priority = 4, enabled = true)
	public void testCarSearchModel() {
		homePage.selectModel();
		String modelText = homePage.getModel();
		if (modelText.contains("Model X")) {
			test.log(LogStatus.PASS, "verify model input");
		} else {
			test.log(LogStatus.FAIL, "verify model input");
		}
	}
	@Test(priority = 5, enabled = true)
	public void testCarSearchMaxPrice() {
		homePage.selectMaxPrice();
		String priceText = homePage.getMaxPrice();
		if (priceText.contains("To £100,000")) {
			test.log(LogStatus.PASS, "verify max price input");
		} else {
			test.log(LogStatus.FAIL, "verify max price input");
		}
	}
	@Test(priority = 6, enabled = true)
	public void testCarPostcode() {
		homePage.getPostcodeInput("PO5 4AY");
		String postcodeInputText = homePage.getPostcodeTextBoxText();
		if (postcodeInputText.equals("PO5 4AY")) {
			test.log(LogStatus.PASS, "Verify postcode input");
		} else {
			test.log(LogStatus.FAIL, "Verify postcode input");
		}
		homePage.clickSearch();
		
		report.endTest(test);
		report.flush();
		tearDown();
		test.log(LogStatus.INFO, "Browser closed");
	}
	public void tearDown() {
		try {
			driver.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

}