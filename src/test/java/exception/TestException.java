package exception;

import org.testng.annotations.Test;
/**
 * 
 * @author simma
 * 异常测试
 *
 */
public class TestException {
  @Test(expectedExceptions= ArithmeticException.class)
  public void testExce() {
	  int i=1/0;
	  System.out.println("After division the value of i is :"+ i);
  }
@Test(expectedExceptions=TestNGDemoException.class,expectedExceptionsMessageRegExp="a*")
public void testExce1() throws TestNGDemoException {
	  throw new TestNGDemoException("aaa");
}
}
