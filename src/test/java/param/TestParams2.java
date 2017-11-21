package param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParams2 {
  @Test
  @Parameters({"param1","param2"})
  public void paramsTest(String param1,String param2) {
	  System.out.println(param1+"——"+param2);
  }
}
