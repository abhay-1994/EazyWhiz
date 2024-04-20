package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackOrdersPage {
	
	public TrackOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='orderid']") private WebElement orderIdTextField;
	@FindBy(id = "exampleBillingEmail1") private WebElement billingEmailTextField;
	@FindBy(xpath = "//button[text()='Track']") private WebElement trackOption;
	public WebElement getOrderIdTextField() {
		return orderIdTextField;
	}
	public WebElement getBillingEmailTextField() {
		return billingEmailTextField;
	}
	public WebElement getTrackOption() {
		return trackOption;
	}
	

}
