package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.mail163.PublicModel;

public class TestDelete {
	private WebDriver driver;
	private String baseUrl;
	@BeforeMethod
	public void setUp(){
	    ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized");
		baseUrl="http://mail.163.com/";
		driver=new ChromeDriver(options);
	}
	@Test
    @Parameters({"username","password"})
    public void verifyLogin(String username,String password) throws Exception{
		driver.get(baseUrl);
		Thread.sleep(10000);
		PublicModel.login(driver, username, password);
		Thread.sleep(5000);
		String text=driver.findElement(By.id("spnUid")).getText();
		System.out.println(text);
		Assert.assertEquals(text, username+"@163.com");
		PublicModel.logout(driver);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
