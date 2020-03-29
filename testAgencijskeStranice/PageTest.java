package testAgencijskeStranice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PageTest {
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testRegBtn() {
		driver.get(home.HOME_URL);
		home.clickRegBtn(driver);
		String current = driver.getCurrentUrl();
		String expected = "http://newtours.demoaut.com/mercuryregister.php";
		//Assert.assertEquals(current, expected);
		boolean ok = current.contains(expected);
		Assert.assertTrue(ok);
	}
	
	@Test
	public void testUnosa() {
		driver.get(home.HOME_URL);
		home.clickRegBtn(driver);
		registration.enterUserName(driver, "koliko");
		registration.enterPassword(driver, "nesto");
		registration.submit(driver);
		
		String expected = "http://newtours.demoaut.com/create_account_success.php";
		Assert.assertEquals(driver.getCurrentUrl(), expected);
	}
}
