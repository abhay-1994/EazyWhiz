package com.tyss.easywhiz.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.tyss.easywhiz.POMRepo.AdminLoginPage;

public class BaseClass {
	public static   WebDriver driver;
	public static WebDriver sdriver;
	public  WebDriverUtility wUtil= new WebDriverUtility();
	public  ExcelUtility eUtil = new ExcelUtility();
	public FileUtility fUtil= new FileUtility();
	public AdminLoginPage lp= new AdminLoginPage(driver);
	  
	
	
	
	
	@BeforeSuite
	public void connectToDB() {
		Reporter.log("DB connected", true);
	}
	
	
	@BeforeClass
	public void launchTheBrowser() throws IOException {
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		//String BROWSER = System.getProperty("browser");
		String URL=System.getProperty("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}

		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}		
		sdriver=driver;
		wUtil.maximizeWindow(driver);
		Reporter.log("Browser launched ", true);
		
		
		
	}
	@BeforeMethod
	 public void implicitWait() {
		wUtil.implicitWait(driver, 20);
	}
	
	@AfterMethod
	public void minimize() {
		driver.manage().window().minimize();
		driver.quit();
		
	}
	
	//@AfterClass
	public void closeTheBrowser() {
		driver.quit();
	}
	@AfterSuite
	public void closeDB() {
		Reporter.log("--DB connectoin closed", true);
	}

}
