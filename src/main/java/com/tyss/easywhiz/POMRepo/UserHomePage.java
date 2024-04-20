package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Login']")  private WebElement userLoginLink;
	@FindBy(xpath = "//span[.='Track Order']") private WebElement trackOrder;
	@FindBy(xpath = "//a[.='Logout']")  private WebElement userLogoutLink;
	public WebElement getUserLogoutLink() {
		return userLogoutLink;
	}
	public WebElement getUserLoginLink() {
		return userLoginLink;
	}
	public WebElement getTrackOrder() {
		return trackOrder;
	}
	
	
	public void loginButtonClick() {
		userLoginLink.click();
	}

}
