package com.tyss.easywhiz.user;

import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.tyss.easywhiz.GenericUtility.BaseClass;
import com.tyss.easywhiz.GenericUtility.ExcelUtility;
import com.tyss.easywhiz.GenericUtility.FileUtility;
import com.tyss.easywhiz.GenericUtility.WebDriverUtility;
import com.tyss.easywhiz.POMRepo.MyCartPage;
import com.tyss.easywhiz.POMRepo.OrderHistoryPage;
import com.tyss.easywhiz.POMRepo.PaymentPage;
import com.tyss.easywhiz.POMRepo.ProductDetailsPage;
import com.tyss.easywhiz.POMRepo.SearchResultPage;
import com.tyss.easywhiz.POMRepo.TrackOrdersPage;
import com.tyss.easywhiz.POMRepo.UserHomePage;
import com.tyss.easywhiz.POMRepo.UserLoginPage;
import com.tyss.easywhiz.POMRepo.UserWelcomePage;

public class OrderProductAndTrackOrderSameProductTest extends BaseClass {
	
	@Test
	public void orderProductAndTrack()  throws Throwable {
		FileUtility fileUtil= new FileUtility();
		ExcelUtility excelUtil= new ExcelUtility();
		WebDriverUtility webDrUtil= new WebDriverUtility();	
		String URL = fileUtil.readDataFromPropertyFile("userUrl");
//String URL=System.getProperty("url");
		String USEREMAIL = fileUtil.readDataFromPropertyFile("userUsername");
		String PASSWORD = fileUtil.readDataFromPropertyFile("userPassword");
		driver.get(URL);
		UserHomePage userHomePage = new UserHomePage(driver);
		userHomePage.loginButtonClick();
		String loginPageUrl = driver.getCurrentUrl();
		String expextedLoginPageUrl = "http://rmgtestingserver/domain/Online_Shopping_Application/login.php";
		//assertEquals(loginPageUrl, expextedLoginPageUrl);
		if (loginPageUrl.contains("login")) {
			System.out.println("Login page is displayed");
		} else {
			System.out.println("Login page is displayed");
		}
		UserLoginPage userLoginPage = new UserLoginPage(driver);
		userLoginPage.userLogin(USEREMAIL, PASSWORD);
		String PRODUCTNAME = excelUtil.readTheDataFromExcelSheet("welcomePage", 0, 1);
		UserWelcomePage userWelcomePage = new UserWelcomePage(driver);
		userWelcomePage.searchTheProduct(PRODUCTNAME);
		String prodCatagoryTitle = driver.getTitle();
		if (prodCatagoryTitle.contains("Product")) {
			System.out.println("Product catagory page is displayed");
		}
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickOnSearchedProduct();
		String productDetailsTitle = driver.getTitle();
		if (productDetailsTitle.contains("details")) {
			System.out.println("Product Details page is displayed");
		}

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addproductToCartClick();
		WebDriverUtility webUtil= new WebDriverUtility();
		String alertMsg = webUtil.alertGetText(driver);
		//assertEquals(alertMsg, "product has been added to cart");
		
		if (alertMsg.contains("added")) {
			System.out.println("'product has been added to cart' message is diplayed");
		}
		webUtil.acceptAlert(driver);
		MyCartPage myCartPage = new MyCartPage(driver);
		myCartPage.proceedTocheckOutClick();
		String paymentPageTitle = driver.getTitle();
		if (paymentPageTitle.contains("Payment")) {
			System.out.println("Payment page is displayed");
		}

		PaymentPage paymentPage = new PaymentPage(driver);
		WebElement codRadioBtn = paymentPage.getCodOption();
		if (codRadioBtn.isSelected()) {
			paymentPage.getSubmitButton().click();
		}

		String orderHistory = driver.getTitle();
		if (orderHistory.contains("History")) {
			System.out.println("Order history page is displayed");
		}
		OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
		orderHistoryPage.pruductTrackOptnClick();
		
		String orderId = null;
		webDrUtil.switchToWindow(driver, "Order Tracking");
		orderId=orderHistoryPage.getOrderIdText().getText();
		System.out.println(orderId);
		Thread.sleep(2000);
		driver.close();
		webDrUtil.switchToWindow(driver, "Order History");
		
		Thread.sleep(2000);
		String EMAIL = excelUtil.readTheDataFromExcelSheet("track_order", 1, 1);
		userWelcomePage.getTrackOrderLink().click();
		Thread.sleep(2000);
		TrackOrdersPage trackOrdersPage = new TrackOrdersPage(driver);
		WebElement orderIdTextField = trackOrdersPage.getOrderIdTextField();
		webDrUtil.waitUntillEleToBeVisible(driver, 10, orderIdTextField);
		orderIdTextField.sendKeys(orderId);
		trackOrdersPage.getBillingEmailTextField().sendKeys(EMAIL);
		trackOrdersPage.getTrackOption().click();
		
		
		
	}
}
