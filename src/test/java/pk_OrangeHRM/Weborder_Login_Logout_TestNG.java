package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Weborder_Login_Logout_TestNG {
  @Test
  public void WeborderLogin() {
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
