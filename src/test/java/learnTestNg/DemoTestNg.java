package learnTestNg;

import org.testng.annotations.Test;

public class DemoTestNg {

	@Test(invocationCount = 0)
	public void login() {
		System.out.println(2/0);
			System.out.println("login");
			
		}
	@Test(priority = 2, invocationCount  = 4, dependsOnMethods = "login")
	public void logout() {
		System.out.println("logout");

		}

	@Test(priority = 3, enabled = false)
	public void home() {
		System.out.println("home");

	}

	@Test
	public void product() {
		System.out.println("product");

	}

	@Test
	public void addToCart() {
		System.out.println("addToCart");

	}

	@Test
	public void payment() {
		System.out.println("payment");

	}

}
