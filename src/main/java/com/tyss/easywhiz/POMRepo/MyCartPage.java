package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {

	
	public MyCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[.='PROCCED TO CHEKOUT']") private WebElement proceedToCheckOutButton;

	public WebElement getProceedToCheckOutButton() {
		return proceedToCheckOutButton;
	}
	
	
	public void proceedTocheckOutClick() {
		proceedToCheckOutButton.click();
	}
}
