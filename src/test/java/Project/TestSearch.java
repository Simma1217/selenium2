package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.mail163.PublicModel;

public class TestSearch {
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
		PublicModel.logout(driver);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
