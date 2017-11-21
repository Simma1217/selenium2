package ignore;

import org.testng.annotations.Test;

public class TestDemoFormal {
  @Test//(enabled=false)
  public void run1() {
	  System.out.println("run1");
  }
  @Test
  public void run2() {
	  System.out.println("run2");

  }
}
