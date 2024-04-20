package com.tyss.easywhiz.POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	
	 WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputEmail")
	private WebElement adminEmailTextField;
	@FindBy(id = "inputPassword")
	private WebElement adminPasswordTextField;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement adminLoginButton;

	public WebElement getAdminEmailTextField() {
		return adminEmailTextField;
	}

	public WebElement getAdminPasswordTextField() {
		return adminPasswordTextField;
	}

	public WebElement getAdminLoginButton() {
		return adminLoginButton;
	}

	/**
	 * This method is used to Login to the Admin module
	 * 
	 * @param adminUsername
	 * @param adminPassword
	 */
	public void loginToAdminmodule(String adminUsername, String adminPassword) {
		adminEmailTextField.sendKeys(adminUsername);
		adminPasswordTextField.sendKeys(adminPassword);
		adminLoginButton.click();
	}

	@FindBy(partialLinkText = "Logout")
	private WebElement adminLogoutButton;

	public WebElement getAdminLogoutButton() {
		return adminLogoutButton;
	}

	/**
	 * This method is used to logout from the admin module
	 */
	public void logoutFromAdminModule() {
		adminLogoutButton.click();
	}

	@FindBy(xpath = "//span[contains(text(),'successfully logout')]")
	private WebElement logoutMessage;

	public WebElement getLogoutMessage() {
		return logoutMessage;
	}

	/**
	 * this method is used to get the Succesful logout message
	 * 
	 * @return
	 */
	public String verifyLogout() {
		String logoutMsg = logoutMessage.getText();
		return logoutMsg;
	}
}
