package param;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParams3Map {
  @Test(dataProvider="mapDataPro")
  public void paramsMapTest(Map<String,String> map) {
	  for(Map.Entry<String, String> entry:map.entrySet()){
		 System.out.println(entry.getKey()+"——"+entry.getValue());
	  }
  }
  @DataProvider(name="mapDataPro")
  public Object[][] dataPro(){
	  Map<String,String> map=new HashMap<String,String>();
	  map.put("param1","simma");
	  map.put("param2","ludahai");
	  map.put("param3","qiqi");
	  return new Object[][]{{map}};
  }
}
