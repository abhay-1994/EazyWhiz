package com.tyss.easywhiz.admin;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.tyss.easywhiz.GenericUtility.DBUtility;
import com.tyss.easywhiz.GenericUtility.ExcelUtility;
import com.tyss.easywhiz.GenericUtility.FileUtility;
import com.tyss.easywhiz.GenericUtility.JavaUtility;
import com.tyss.easywhiz.GenericUtility.WebDriverUtility;
import com.tyss.easywhiz.POMRepo.AdminLoginPage;

public class AdminLogiLogoutTest {
	static WebDriver driver;
	

	@Test
	public void loginLogout() throws IOException, InterruptedException {
		JavaUtility javaUtil=new JavaUtility();
		FileUtility fileUtil= new FileUtility();
		ExcelUtility excelUtil= new ExcelUtility();
		WebDriverUtility webDrUtil= new WebDriverUtility();
		DBUtility dbUtil = new DBUtility();
		//read the data from property file
		String BROWSER = fileUtil.readDataFromPropertyFile("browser");		
		String ADMINURL = fileUtil.readDataFromPropertyFile("adminUrl");
		String ADMINUSERNAME = fileUtil.readDataFromPropertyFile("adminUsername");
		String ADMINPASSWORD = fileUtil.readDataFromPropertyFile("adminPassword");
		if(BROWSER.equals("chrome"))
			driver=new ChromeDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else
			System.out.println("INVALID!!!!");
		System.out.println("Browser Launched");
		webDrUtil.maximizeWindow(driver);
		System.out.println("Window Maximized");
		webDrUtil.implicitWait(driver, 10);
		driver.get(ADMINURL);
		System.out.println("Navigated to the url");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToAdminmodule(ADMINUSERNAME, ADMINPASSWORD);
		adminLoginPage.logoutFromAdminModule();
		Reporter.log("Logged In", true);//it will print the message in the report and log
	    String logoutSuccesfullmsg = adminLoginPage.verifyLogout();
	    SoftAssert sA=new SoftAssert();
	    sA.assertEquals(logoutSuccesfullmsg, "You have successfully logout", "Logged Out Successfully");
	    Reporter.log("Pass: Logout Succesful message is displayed", true);
//		if(logoutSuccesfullmsg.contains("You have successfully logout")) {
//			System.out.println("Pass: Logout Succesful message is displayed");
//		Reporter.log("Pass: Logout Succesful message is displayed", true);
//		}
//		else {
//			System.out.println("Fail: Logout Succesful message is not displayed");
//			Reporter.log("Fail: Logout Succesful message is not displayed", true);
//		}
//		
		
		

	}
	

}
