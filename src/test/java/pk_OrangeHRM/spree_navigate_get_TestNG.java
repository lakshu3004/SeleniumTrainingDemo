package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spree_navigate_get_TestNG {
	WebDriver driver;
  @Test
  public void Login_001() {
	  driver.findElement(By.xpath("//a[@href='/t/categories/women'][1]")).click();
      // Verifying Current URL
      String ExpURL = "https://demo.spreecommerce.org/t/categories/women";
      String ActURL = driver.getCurrentUrl();
      Assert.assertEquals(ActURL, ExpURL);
      // Verifying Title
      String ExpTitle = "Homepage (English) - Spree Demo Site";
      String ActTile = driver.getTitle();
      Assert.assertEquals(ActTile, ExpTitle);
      driver.navigate().back();
      String ExpTitle1 = "Homepage (English) - Spree Demo Site";
      String ActTile1= driver.getTitle();
      Assert.assertEquals(ActTile1, ExpTitle1);
      driver.navigate().forward();
      String ExpURLForward="https://demo.spreecommerce.org/t/categories/women";
      String ActURLForward=driver.getCurrentUrl();
      Assert.assertEquals(ExpURLForward, ActURLForward);
      driver.navigate().refresh();
      String ExpURLForward1="https://demo.spreecommerce.org/t/categories/women";
      String ActURLForward1=driver.getCurrentUrl();
      Assert.assertEquals(ExpURLForward1, ActURLForward1);

      //Verify the Dashboard page
    //  String Exp_Page_Value = "Summer Collection SHOP NOW";
     // String Act_Page_Value = driver.findElement(By.xpath("/html/body/div[4]/main/div/div[1]/div")).getText();
     // Assert.assertEquals(Act_Page_Value, Exp_Page_Value);
  }
  @BeforeTest
  // @Test(priority=1)
  public void LaunchBrowser() {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      // This will wait for Page to load
      // driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
      // This will store or rememember the cookies or navigation in terms of
      // back and forward
      driver.navigate().to("https://demo.spreecommerce.org/");
  }

  // Post Condition
  
}

