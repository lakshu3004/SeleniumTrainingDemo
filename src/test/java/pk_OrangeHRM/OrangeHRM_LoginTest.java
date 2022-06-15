package pk_OrangeHRM;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_LoginTest {

	@Test
	public void Login_Veification() {
		//1.Launch browser(chrome)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//2.Enter the URL
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboards");
		//3.Enter the valid user name
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.quit();
	}

}
