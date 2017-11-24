package Project;

import java.util.List;

import org.openqa.selenium.By;
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

public class TestSend {
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
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id='_mail_component_70_70']/span[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("479921347@qq.com");
		driver.findElement(By.xpath("//input[contains(@id, 'subjectInput')]")).sendKeys("测试163邮箱发送");
		driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
		driver.findElement(By.xpath("/html/body")).sendKeys("我就测试一下，来来来");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		List<WebElement> spans=driver.findElements(By.xpath("//span[@class='nui-btn-text']"));
		for(WebElement span:spans){
			String text=span.getText();
			if("发送".equals(text)){
				span.click();
			}
		}
		String text =driver.findElement(By.className("tK1")).getText();
		System.out.println(text);
		int index=text.indexOf("发送成功");
		Assert.assertNotEquals(index, -1);
		PublicModel.logout(driver);
	}
	@AfterMethod
	public void tearDown(){
//		driver.quit();
	}
}
