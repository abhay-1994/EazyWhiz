package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//input[@value='COD']") private WebElement codOption;
	@FindBy(xpath = "//input[@name='submit']") private WebElement submitButton;
	public WebElement getCodOption() {
		return codOption;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void submitButtonClick() {
		submitButton.click();
	}

}
