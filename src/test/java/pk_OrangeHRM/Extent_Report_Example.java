package pk_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report_Example {
 
//builds a new report using the html template 
  ExtentSparkReporter htmlReporter;
  ExtentReports extent;
  //helps to generate the logs in test report.
  ExtentTest test;
  ChromeDriver driver;
  @Test(priority = 2)
  public void OrangeHRM_Login() throws Exception {
      driver.findElement(By.name("txtUsername")).sendKeys("Admin");
      driver.findElement(By.name("txtPassword")).sendKeys("admin123");
      driver.findElement(By.id("btnLogin")).click();
      driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }

  @Test(priority = 3)
  public void OrangeHRM_Logout() throws Exception {
      driver.findElement(By.id("welcome")).click();
      Thread.sleep(2000);
      driver.findElement(By.linkText("Logoutt")).click();
  }

/*
  @Test(priority= 2)
  public void Sign_On() throws InterruptedException

  {

      test = extent.createTest("Test Case 2", "Login to OrangeHRM Application");
      //driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
      driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
      driver.findElement(By.name("txtUsername")).sendKeys("Admin");
      driver.findElement(By.name("txtPassword")).sendKeys("admin123");
      driver.findElement(By.id("btnLogin")).click();
      String Element = driver.findElement(By.linkText("Dashboardd")).getText();
      System.out.println(Element);
      driver.findElement(By.id("welcome")).click();
      Thread.sleep(5000);
      driver.findElement(By.linkText("Logout")).click();
  }
  */

  @Test(priority= 1)
  public void LaunchApplication()

  {

      test = extent.createTest("Test Case 1", "Launching Chrome Browser");

      WebDriverManager.chromedriver().setup();
      //WebDriverManager.chromedriver().setup();
      //driver = new ChromeDriver();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
  }

  @BeforeTest()
  public void startReport() {
      // initialize the HtmlReporter
      htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/ExtentReport.html");
      //initialize ExtentReports and attach the HtmlReporter
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
      //To add system or environment info by using the setSystemInfo method.
      extent.setSystemInfo("OS", System.getProperty("os.name"));
      extent.setSystemInfo("Browser", "Chrome Latest");
      extent.setSystemInfo("QA Name", "Abhi");

      //configuration items to change the look and feel
      //add content, manage tests etc
      //htmlReporter.config().setChartVisibilityOnOpen(true);
      htmlReporter.config().setDocumentTitle("OrangeHRM - Extent Report");
      htmlReporter.config().setReportName("Smoke Test Report");
      //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
      htmlReporter.config().setTheme(Theme.DARK);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

  }

  @AfterTest
  public void CloseBrowser()

  {
      driver.quit();
      //to write or update test information to reporter
      extent.flush();
  }

  @AfterMethod
  public void getResult(ITestResult result) throws Exception {
      if(result.getStatus() == ITestResult.FAILURE) {
          test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
          test.fail(result.getThrowable());
          String screenshotPath = Baseclass.getScreenshotfailure(driver, result.getName());
          //To add it in the extent report 
          test.addScreenCaptureFromPath(screenshotPath);//This is for Screenshot

      }
      else if(result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
          String screenshotPath = Baseclass.getScreenshotSuccess(driver, result.getName());
          //To add it in the extent report 
          test.addScreenCaptureFromPath(screenshotPath);//This is for Screenshot
      }
      else {
          test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
          test.skip(result.getThrowable());
      }
  }
}