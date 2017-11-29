package seleniumChapter9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestBaidu {
	private WebDriver driver;
	private String url;
  @BeforeClass
  public void setUp() {
	  driver=new ChromeDriver();
	  url="https://www.baidu.com/";
	  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
  }
  @Test
  public void testCase() throws Exception {
	  driver.get(url);
	  driver.findElement(By.id("kw")).sendKeys("testNG");
	  driver.findElement(By.id("su")).click();
	  Thread.sleep(2000);
	  String text=driver.getTitle();
	  Assert.assertEquals(text,"testNG_百度搜索");

  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
