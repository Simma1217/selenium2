package testng;

import org.testng.annotations.Test;

public class TestMethodGroup {
  @Test(groups="group1")
  public void groupA() {
	  System.out.println("groupAmethod");
  }
  @Test(groups="group1")
  public void groupb() {
	  System.out.println("groupBmethod");

  }
}
