package testAgencijskeStranice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class home {
	public static String HOME_URL= "http://newtours.demoaut.com/";
	public static String REGISTER_BTN_XPATH = "//a[contains(text(),'REGISTER')]";

	public static void clickRegBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(REGISTER_BTN_XPATH));
		btn.click();
	}


}
