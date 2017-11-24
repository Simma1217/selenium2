package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.mail163.PublicModel;

public class TestAccount {
	private WebDriver driver;
	private String baseUrl;
	@BeforeMethod
	public void setUp() throws Exception{
	    ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized");
		baseUrl="http://mail.163.com/";
		driver=new ChromeDriver(options);
		driver.get(baseUrl);
		Thread.sleep(10000);
		driver.switchTo().frame("x-URS-iframe");
	}
	@Test(dataProvider="dataPro")
    public void verifyLogin(String username,String password,String msg) throws Exception{
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		//使用登录按钮提交
		driver.findElement(By.id("dologin")).click();
		Thread.sleep(5000);
		String msg1=driver.findElement(By.className("ferrorhead")).getText();
		System.out.println("账号："+username+"-"+"密码："+password+"-"+msg1);
	}
	 @DataProvider(name="dataPro")
	  public Object[][] dataPro(){
		  return new Object[][]{
				  {"","","请输入帐号"},
				  {"zaichangma","","请输入密码"},
				  {"","aaaa","请输入帐号"},
				  {"zaichangma","aaa","帐号或密码错误"},
				  {"aaa","27japan!!","帐号或密码错误"},
				  {"aaa","bbb","帐号或密码错误"}
				  };
	  }
/*	@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/
}
