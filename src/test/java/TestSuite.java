
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestSuite {
  @Test
  public void run() {
	  System.out.println("TestSuite-run");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I AM @beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("I AM @afterMethod");
  }
  @AfterMethod
  public void afterMethod1() {
	  System.out.println("I AM @afterMethod1");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("I AM @BeforeSuite");

  }
  @BeforeSuite
  public void beforeSuite1() {
	  System.out.println("I AM @BeforeSuite1");

  }
  @AfterSuite
  public void afterSuite() {
	  System.out.println("I AM @AfterSuite");
  }
  @BeforeTest
  public void beforeTest(){
	  System.out.println("I AM @BeforeTest");

  }
  @AfterTest
  public void afterTest(){
	  System.out.println("I AM @AfterTest");
  }
  @AfterTest
  public void afterTest1(){
	  System.out.println("I AM @AfterTest1");

  }
  @BeforeGroups(groups="group1")
  public void beforeGroups(){
	  System.out.println("I AM @BeforeGroups");
  }
  @AfterGroups(groups="group1")
  public void afterGroups(){
	  System.out.println("I AM @AfterGroups");
  }
  @BeforeGroups(groups="classGroup")
  public void beforeGroupClass(){
	  System.out.println("I AM @BeforeGroups");
  }
  
}
