package pk_OrangeHRM;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {
  @Test
  public void D_Test1() {
	  System.out.println("D_Test1");
  }
  @Test(priority=1)
  public void F_Test1() {
	  System.out.println("F_Test1");
  }
  @Test
  public void A_Test1() {
	  System.out.println("A_Test1");
  }
  @Test
  public void W_Test1() {
	  System.out.println("W_Test1");
  }
  @Test
  public void K_Test1() {
	  System.out.println("K_Test1");
  }
  /*@BeforeMethod
  public void Test2() {
	  System.out.println("Test2");
  }
  @AfterClass
  public void Test3() {
	  System.out.println("Test3");
  }
  @AfterSuite
  public void Test4() {
	  System.out.println("Test4");
  }
  @BeforeClass
  public void Test5() {
	  System.out.println("Test5");
  }
  @BeforeTest
  public void Test6() {
	  System.out.println("Test6");
  }
  @BeforeSuite
  public void Test7() {
	  System.out.println("Test7");
  }
  @AfterMethod
  public void Test8() {
	  System.out.println("Test8");
  }
  @AfterTest
  public void Test9() {
	  System.out.println("Test9");
  }*/
}
