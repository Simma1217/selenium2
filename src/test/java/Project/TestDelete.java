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
    public void delete(String username,String password) throws Exception{
		driver.get(baseUrl);
		Thread.sleep(10000);
		PublicModel.login(driver, username, password);
		Thread.sleep(8000);
		WebElement emailReceive=driver.findElement(By.xpath("//span[@class='nui-tree-item-text' and @title='收件箱']"));
		//点击收件箱
		emailReceive.click();
		Thread.sleep(5000);
		//获取第一封邮件的复选框
		List<WebElement> checkboxs=driver.findElements(By.xpath("//span[@class='nui-chk-symbol']/b"));
		System.out.println("checkboxs"+checkboxs);
		int i=1;
		for(WebElement checkbox:checkboxs){
			if(i==2){
			checkbox.click();
			break;
			}
			i++;
		}
		Thread.sleep(2000);
		//点击删除按钮
		List<WebElement> spans=driver.findElements(By.xpath("//span[@class='nui-btn-text']"));
		for(WebElement span:spans){
			if(span.getText().equals("删 除")){
				System.out.println(span.getText());
				span.click();
			}
		}
/*		Thread.sleep(5000);
		//断言是否已删除
		String text=driver.findElement(By.xpath("//span[@class='nui-tips-text']/a")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"已删除");*/

		
		//PublicModel.logout(driver);
	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//	}
}
