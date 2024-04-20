package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[text()='Nivia FootBall Gloves']") private WebElement searchedProduct;
	@FindBy(xpath = "//button[.='Add to cart']") private WebElement addToCart;


	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getSearchedProduct() {
		return searchedProduct;
	}
	
	public void clickOnSearchedProduct() {
		searchedProduct.click();
	}
	
}
