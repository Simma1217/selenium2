package timeout;

import org.testng.annotations.Test;
/**
 * 测试超时
 * @author simma
 *
 */
public class TestTimeout {
  @Test(timeOut=5000)
  public void run1() throws Exception {
	  Thread.sleep(6000);
  }
  @Test(timeOut=1000)
  public void run2() {
	  while(true){
		  
	  }
  }
}
