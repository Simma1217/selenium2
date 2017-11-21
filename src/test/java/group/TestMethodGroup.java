package group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestMethodGroup {
  @AfterGroups(groups="selenium-test")
  public void afterGroups(){
	  System.out.println("I AM @AfterGroups");
  }
  @BeforeGroups(groups="selenium-test")
  public void beforeGroupClass(){
	  System.out.println("I AM @BeforeGroups");
  }
  @Test(groups="group1")
  public void groupA() {
	  System.out.println("groupAmethodA");
  }
  @Test(groups="group1")
  public void groupb() {
	  System.out.println("groupBmethodB");

  }
  @Test(dependsOnGroups={"group1"})
  public void finalFun() {
      System.out.println("finalFun");
  }
  @Test(groups = "selenium-test")
  public void runSelenium() {
      System.out.println("runSelenium()");
  }

  @Test(groups = "selenium-test")
  public void runSelenium1() {
      System.out.println("runSelenium()1");
  }
  @Test(groups = {"selenium-test","group1"})
  public void groups() {
      System.out.println("groups");
  }

}
