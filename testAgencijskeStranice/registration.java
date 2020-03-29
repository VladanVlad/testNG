package testAgencijskeStranice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registration {
	//url, xpath za obavezna polja i jedno proizvoljno neobavezno
	//napisati metodu koja unosi zadate podatke u ta polja
	public static final String URL = "http://newtours.demoaut.com/mercuryregister.php";
	public static String userName = "//input[@id='email']";
	public static String password = "//input[@name='password']";
	public static String confPass = "//input[@name='confirmPassword']";
	public static String submit = "//input[@name='register']";
	
	public static void enterUserName(WebDriver driver, String enter) {
		WebElement box = driver.findElement(By.xpath(userName));
		box.sendKeys(enter);
	}
	
	public static void enterPassword(WebDriver driver, String enter) {
		WebElement box = driver.findElement(By.xpath(password));
		box.sendKeys(enter);
		box = driver.findElement(By.xpath(confPass));
		box.sendKeys(enter);
	}

	public static void submit(WebDriver driver) {
		WebElement box = driver.findElement(By.xpath(submit));
		box.click();
	}

}
