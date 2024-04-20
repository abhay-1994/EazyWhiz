package learnTestNg;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class LearnTestNgAnnotations {
	
	@Test(priority = 1)
	public void actualTestScript2() {
		System.out.println("-actualTestScript2>--------Actual testScript-----------");
	}
	
	
	
	@BeforeSuite
	public void bSuite() {
		System.out.println("-bSuite>------DB connection-----------");
	}
	
	
	@BeforeClass
	public void bClass() {
		System.out.println("-bClass>------launch browser-----------");
	}
	
	
	@BeforeTest
	public void bTest() {
		System.out.println("-bTest>------Test configuration-----------");
	}
	
	@BeforeMethod
	public void bMethod() {
		System.out.println("-bMethod>------Login to appln-----------");
	}
	
	@Test(priority = 2)
	public void actualTestScript() {
		System.out.println("-actualTestScript>--------Actual testScript-----------");
	}
	
	@AfterSuite
	public void aSuite() {
		System.out.println("-aSuite>------ close DB connection-----------");
	}
	
	
	@AfterClass
	public void aClass() {
		System.out.println("-aClass>------close browser-----------");
	}
	
	
	@AfterMethod
	public void aMethod() {
		System.out.println("-aMethod>------Logout to appln-----------");
	}

}
