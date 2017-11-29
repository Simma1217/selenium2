package selenium2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.mail163.PublicModel;

public class DependTest {
/*  @Test
  @Parameters({"username","password"})
  public void verifyLogin(String username,String password) throws Exception{
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized");
		System.out.println("163邮箱登录");
		String url="http://mail.163.com/";
		WebDriver driver=new ChromeDriver(options);
		driver.get(url);
		Thread.sleep(10000);
		PublicModel.login(driver, username, password);
		Thread.sleep(5000);
		String text=driver.findElement(By.id("spnUid")).getText();
		Assert.assertEquals("zaichangma@163.com", text);
		PublicModel.logout(driver);
		
  }*/
  @Test//(dependsOnMethods={"verifyLogin"})
  @Parameters({"username","password"})
  public void verifySearch(String username,String password) throws Exception{
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized");
		System.out.println("163邮箱登录");
		String url="http://mail.163.com/";
		WebDriver driver=new ChromeDriver(options);
		driver.get(url);
		Thread.sleep(5000);
		PublicModel.login(driver, username, password);
		Thread.sleep(5000);
		WebElement search=driver.findElement(By.xpath("//input[@class='nui-ipt-input' and @type='text']"));
		search.sendKeys("simma");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WebElement resultTitle=driver.findElement(By.xpath("//h1[@class='nui-title-text']"));
		String text=resultTitle.getText();
		System.out.println(text);
		Assert.assertEquals(text, "搜索结果");

//		PublicModel.logout(driver);		
  }
}
