package learnTestNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tyss.easywhiz.POMRepo.AdminLoginPage;

public class DataProviderImplementation {

	@Test(dataProviderClass = DataProviderConcept.class ,dataProvider = "logindata")
	public void loginToAdmin(String username, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/index.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AdminLoginPage lp= new AdminLoginPage(driver);
		lp.loginToAdminmodule(username, password);
		

	}
}
