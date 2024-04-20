package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//User login elements
	@FindBy(id = "exampleInputEmail1") private WebElement userEmailTextField;
	@FindBy(id = "exampleInputPassword1") private WebElement userPasswordTextField;
	@FindBy(xpath = "//button[text()='Login']") private WebElement userLoginButton;
	
	//User signUp elements
	@FindBy(id = "fullname") private WebElement userFullName;
	@FindBy(id = "email") private WebElement userEmail;
	@FindBy(id = "contactno") private WebElement userContact;
	@FindBy(id = "password") private WebElement userPassword;
	@FindBy(id = "confirmpassword") private WebElement userConfirmPassword;
	
	
	//getter methods
	public WebElement getUserEmailTextField() {
		return userEmailTextField;
	}
	public WebElement getUserPasswordTextField() {
		return userPasswordTextField;
	}
	public WebElement getUserLoginButton() {
		return userLoginButton;
	}
	public WebElement getUserFullName() {
		return userFullName;
	}
	public WebElement getUserEmail() {
		return userEmail;
	}
	public WebElement getUserContact() {
		return userContact;
	}
	public WebElement getUserPassword() {
		return userPassword;
	}
	public WebElement getUserConfirmPassword() {
		return userConfirmPassword;
	}
	
	
	public void userLogin(String userName, String password) {
		userEmailTextField.sendKeys(userName);
		userPasswordTextField.sendKeys(password);
		userLoginButton.click();
	}

	
	

}
