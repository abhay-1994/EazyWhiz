package com.tyss.easywhiz.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is used to maximize the browser window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to provide Implicit wait to the WebElement
	 * 
	 * @param driver
	 */
	public void implicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	/**
	 * This method is used to provide pageloadTimeOut
	 * 
	 * @param driver
	 * @param sec
	 */
	public void pageLoadingTimeOut(WebDriver driver, int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}

	/**
	 * this method will return the WebDriver wait object.
	 * 
	 * @param driver
	 * @param sec
	 * @return WebDriverWait wait object
	 */
	public WebDriverWait webDriverWaitObject(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}

	/**
	 * This method is used to provide explicit wait with the condition Visibility of element.
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntillEleToBeVisible(WebDriver driver, int sec, WebElement ele) {
		webDriverWaitObject(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * This method is used to provide explicit wait with the condition element to be clickable.
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntillEleToBeClickable(WebDriver driver, int sec, WebElement ele) {
		webDriverWaitObject(driver, sec).until(ExpectedConditions.elementToBeClickable(ele));
	}

	public Actions performActionObject(WebDriver driver) {
		Actions action = new Actions(driver);
		return action;
	}
	

	/**
	 * This method is used to Mouse hover on the particular element.
	 * @param driver
	 * @param ele
	 */
	public void movetoElement(WebDriver driver, WebElement ele) {
		performActionObject(driver).moveToElement(ele).perform();
	}
	

	/**
	 * This method is used to double click on active element.
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		performActionObject(driver).doubleClick().perform();
	}

	/**
	 * This method is used to double click on element.
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver, WebElement ele) {
		performActionObject(driver).doubleClick(ele).perform();
	}

	/**
	 * This method is used to right click on active element.
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		performActionObject(driver).contextClick().perform();
	}

	/**
	 *  This method is used to right click on element.
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver, WebElement ele) {
		performActionObject(driver).contextClick(ele).perform();
	}

	/**
	 *  This method is used to drag and drop the element from source to destination.
	 * @param driver
	 * @param src
	 * @param trg
	 */
	public void dragAndDropToTarget(WebDriver driver, WebElement src, WebElement trg) {
		performActionObject(driver).dragAndDrop(src, trg).perform();;
	}

	/**
	 * This method is used to drag and drop the element to particular x and yAxis.
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDropToAxis(WebDriver driver, WebElement src, int x, int y) {
		performActionObject(driver).dragAndDropBy(src, x, y).perform();
	}

	public void sendKeys(WebDriver driver) {
		performActionObject(driver).sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method will return the object of Select class
	 * 
	 * @param ele
	 * @return
	 * @author a
	 */
	public Select dropDownObject(WebElement ele) {
		Select sel = new Select(ele);
		return sel;
	}

	/**
	 * This method is used to handle the dropdown using index.
	 * @param ele
	 * @param index
	 */
	public void handledropdown(WebElement ele, int index) {
		dropDownObject(ele).selectByIndex(index);
	}

	/**
	 * This method is used to handle the dropdown using value.
	 * @param ele
	 * @param value
	 */
	public void handledropdown(WebElement ele, String value) {
		dropDownObject(ele).selectByValue(value);
	}

	/**
	 * This method is used to handle the dropdown using visible text.
	 * @param text
	 * @param ele
	 */
	public void handledropdown(String text, WebElement ele) {
		dropDownObject(ele).selectByVisibleText(text);
	}

	/**
	 * This method is used to switch to particular window with title verification
	 * 
	 * @param driver
	 * @param expWindowTitle
	 */

	public void switchToWindow(WebDriver driver, String expWindowTitle) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iT = windows.iterator();// Iterator is the super most interface of Collections.
		while (iT.hasNext()) {
			String window = iT.next();
			String CurrentTitle = driver.switchTo().window(window).getTitle();
			if (CurrentTitle.contains(expWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * This method is used to Accept the Alert pop-up.
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to Reject the Alert pop-up.
	 * 
	 * @author a
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to get the text of Alert popup
	 * @param driver
	 * @param alerttext
	 * @return
	 */
	public String alertGetText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	/**
	 * This method is used to take the screen shot
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */

	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File temp = tss.getScreenshotAs(OutputType.FILE);
		String Path = "./ScreenShot/" + screenShotName + ".png";
		File perm = new File(Path);
		String srcpath = perm.getAbsolutePath();
		FileUtils.copyFile(temp, perm);
		return srcpath;

	}

	/**
	 * This method is used to scroll usin javaScript executor within given y axis
	 * value
	 * 
	 * @param driver
	 * @param y
	 */

	public void scrollTillYAxis(WebDriver driver, int y) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + y + ")");
	}

	/**
	 * This method is used to scroll till last of the web page
	 * 
	 * @param driver
	 * @param ele
	 */

	public void scrollBarTillLast(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = ele.getLocation().getY();
		jse.executeScript("window.scrollBy(0," + y + ")");
	}

	/**
	 * This method is used to click on the element using javaScript executor
	 * 
	 * @param driver
	 * @param ele
	 */

	public void clickOnElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
	}

	/**
	 * This method is used to scroll till the element using javaScript executor
	 * 
	 * @param driver
	 * @param ele
	 */
	public void scrollTillElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollintoView()", ele);
	}

	/**
	 * This method is used to send data to the element using javaScript executor
	 * 
	 * @param driver
	 * @param ele
	 * @param data
	 */
	public void sendDataThroughJSExecutor(WebDriver driver, WebElement ele, String data) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=argument[1]", ele, data);
	}
	
	
	
	
	

}
