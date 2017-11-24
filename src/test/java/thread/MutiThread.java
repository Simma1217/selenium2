package thread;

import org.testng.annotations.Test;

public class MutiThread {
	int i=0;
  @Test(invocationCount=3,threadPoolSize=3)
  public void fun1() {
	  System.out.println("test"+(i++)+"——"+Thread.currentThread().getName());
  }
}
