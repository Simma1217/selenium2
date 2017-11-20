package testng;

import org.junit.Assert;
import org.testng.annotations.Test;

public class FirstTest {
  @Test
  public void f() {
	  RandomEmailGenerator reg=new RandomEmailGenerator();
	  String text=reg.generate();
	  Assert.assertNotNull(text);
	  Assert.assertEquals(text, "zaichangma@173.com");
  }
}
