package testng;

import org.testng.annotations.Test;
@Test(groups="classGroup")
public class TestClassGroup {
  @Test
  public void f() {
	  System.out.println("classGroup");
  }
}
