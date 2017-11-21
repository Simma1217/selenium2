package param;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParamsDataPro {
  @Test(dataProvider="dataPro")
  public void paramsTest(int param1,int param2) {
	  System.out.println(param1+"——"+param2);
	  Assert.assertEquals(param1+10,param2);
  }
  @DataProvider(name="dataPro")
  public Object[][] dataPro(){
	  return new Object[][]{{10,20},{20,30},{30,40}};
  }
}
