package group;

import org.testng.annotations.Test;
@Test(groups="selenium-test")
public class TestClassGroup {
  @Test
  public void fun1() {
	  System.out.println("function1");
  }
  @Test
  public void fun2() {
	  System.out.println("function2");
  }
}
