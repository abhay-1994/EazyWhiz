package com.tyss.easywhiz.admin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tyss.easywhiz.GenericUtility.BaseClass;
import com.tyss.easywhiz.POMRepo.AdminLoginPage;

public class AdminLoginLogoutBaseClassTest extends BaseClass{


	@Test
	public void loginLogout() throws Throwable {
		String ADMINURL = fUtil.readDataFromPropertyFile("adminUrl");
		String ADMINUSERNAME = fUtil.readDataFromPropertyFile("adminUsername");
		String ADMINPASSWORD = fUtil.readDataFromPropertyFile("adminPassword");
		driver.get(ADMINURL);
		wUtil.implicitWait(driver, 10);
		lp= new AdminLoginPage(driver);
		System.out.println(ADMINUSERNAME +" " +ADMINPASSWORD );
		//AdminLoginPage lp= new AdminLoginPage(driver);
		
		lp.loginToAdminmodule(ADMINUSERNAME, ADMINPASSWORD);
		Reporter.log("Successfully logged in", true);
		
		lp.logoutFromAdminModule();
		Reporter.log("Logged out succesfully", true);
		
		
	}
}
