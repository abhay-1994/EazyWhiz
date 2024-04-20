package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserWelcomePage {
	public UserWelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//input[@placeholder='Search here...']") private WebElement searchTextField;
	@FindBy(name = "search") private WebElement searchbutton;
	@FindBy(xpath = "//a[.='My Account']") private WebElement myAccountLink;
	@FindBy(xpath = "//a[.='Wishlist']") private WebElement wishlistLink;
	@FindBy(xpath = "//a[.='My Cart']") private WebElement myCartLink;
	@FindBy(xpath = "//a[.='Logout']") private WebElement logoutLink;
	@FindBy(xpath = "//span[.='Track Order']") private WebElement trackOrderLink;
	@FindBy(xpath = "//a[@class='dropdown-toggle lnk-cart']") private WebElement cartbutton;
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getSearchbutton() {
		return searchbutton;
	}
	public WebElement getMyAccountLink() {
		return myAccountLink;
	}
	public WebElement getWishlistLink() {
		return wishlistLink;
	}
	public WebElement getMyCartLink() {
		return myCartLink;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getTrackOrderLink() {
		return trackOrderLink;
	}
	public WebElement getCartbutton() {
		return cartbutton;
	}
	
	
	/**
	 * This method is used to search the product
	 * @param productName
	 */
	public void searchTheProduct(String productName) {
		searchTextField.sendKeys(productName, Keys.ENTER);
		
	}
	
	
}
