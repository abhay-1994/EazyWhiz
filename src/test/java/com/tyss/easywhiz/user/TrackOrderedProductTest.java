package com.tyss.easywhiz.user;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tyss.easywhiz.GenericUtility.DBUtility;
import com.tyss.easywhiz.GenericUtility.ExcelUtility;
import com.tyss.easywhiz.GenericUtility.FileUtility;
import com.tyss.easywhiz.GenericUtility.JavaUtility;
import com.tyss.easywhiz.GenericUtility.WebDriverUtility;
import com.tyss.easywhiz.POMRepo.TrackOrdersPage;
import com.tyss.easywhiz.POMRepo.UserHomePage;
import com.tyss.easywhiz.POMRepo.UserLoginPage;
import com.tyss.easywhiz.POMRepo.UserWelcomePage;

public class TrackOrderedProductTest {
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		JavaUtility javaUtil = new JavaUtility();
		FileUtility fileUtil = new FileUtility();
		ExcelUtility excelUtil = new ExcelUtility();
		WebDriverUtility webDrUtil = new WebDriverUtility();
		// fetching the data from properties file

		String BROWSER = fileUtil.readDataFromPropertyFile("browser");
		String URL = fileUtil.readDataFromPropertyFile("userUrl");
		String USEREMAIL = fileUtil.readDataFromPropertyFile("userUsername");
		String PASSWORD = fileUtil.readDataFromPropertyFile("userPassword");

// Actual Test script

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid browser");
		}
//maximize window
		webDrUtil.maximizeWindow(driver);

//implicit wait

		webDrUtil.implicitWait(driver, 20);

		driver.get(URL);
		UserHomePage userHomePage = new UserHomePage(driver);
		userHomePage.loginButtonClick();
		String loginPageUrl = driver.getCurrentUrl();
		if (loginPageUrl.contains("login")) {
			System.out.println("Login page is displayed");
		} else {
			System.out.println("Login page is displayed");
		}
		UserLoginPage userLoginPage = new UserLoginPage(driver);
		userLoginPage.userLogin(USEREMAIL, PASSWORD);
		
//Read the data from excel
		String ORDERID = excelUtil.readTheDataFromExcelSheet("track_order", 0, 1);
		String EMAIL = excelUtil.readTheDataFromExcelSheet("track_order", 1, 1);
		UserWelcomePage userWelcomePage = new UserWelcomePage(driver);
		userWelcomePage.getTrackOrderLink().click();
		TrackOrdersPage trackOrdersPage = new TrackOrdersPage(driver);
		trackOrdersPage.getOrderIdTextField().sendKeys(ORDERID);
		trackOrdersPage.getBillingEmailTextField().sendKeys(EMAIL);
		trackOrdersPage.getTrackOption().click();

	}

}
