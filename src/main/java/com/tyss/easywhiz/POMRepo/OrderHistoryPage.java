package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
      
	public OrderHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr[last()]/td[last()]/a") private WebElement productTrackOptn;
	@FindBy(xpath = "//td[@class='fontkink']") private WebElement orderIdText;


	public WebElement getOrderIdText() {
		return orderIdText;
	}

	public WebElement getProductTrackOptn() {
		return productTrackOptn;
	}
	
	public void pruductTrackOptnClick() {
		productTrackOptn.click();
	}
}
