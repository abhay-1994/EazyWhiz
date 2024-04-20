package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[contains(text(),'Create Category')]") private WebElement createCategorybutton;
	@FindBy(name = "category") private WebElement categoryTextField;
	@FindBy(name = "description") private WebElement descriptionTextField;
	@FindBy(name = "submit") private WebElement createCategorySubmitButton;

	public WebElement getCreateCategorySubmitButton() {
		return createCategorySubmitButton;
	}


	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}


	public WebElement getCategoryTextField() {
		return categoryTextField;
	}


	public WebElement getCreateCatagorybutton() {
		return createCategorybutton;
	}
	
	/**
	 * This method is used to Create the catagory
	 * @param categoryName
	 * @param description
	 */
	public void createCatagory(String categoryName, String description) {
		createCategorybutton.click();
		categoryTextField.sendKeys(categoryName);
		descriptionTextField.sendKeys(description);
		createCategorySubmitButton.click();
		
		
	}

}
