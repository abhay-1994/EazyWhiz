package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' ADD TO CART']")
	private WebElement addToCartButton;
	@FindBy(xpath = "//div[@class='favorite-button m-t-10']//a[@class='btn btn-primary']")
	private WebElement wishlistButton;
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	public WebElement getWishlistButton() {
		return wishlistButton;
	}

	
	public void addproductToCartClick() {
		addToCartButton.click();
	}
}
