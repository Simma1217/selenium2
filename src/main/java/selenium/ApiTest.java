package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApiTest {
	//�������ǰ������
	@Test
	public void browerControl(){
		WebDriver wd=new FirefoxDriver();
		String firstUrl="https://www.baidu.com";
		System.out.println("now access first url"+firstUrl);
		wd.get(firstUrl);
		String secoundUrl="https://news.baidu.com";
		System.out.println("now access secound url"+secoundUrl);
		wd.get(secoundUrl);
		System.out.println("now back to first url"+firstUrl);
		wd.navigate().back();
		System.out.println("now forward to secound url"+secoundUrl);
		wd.navigate().forward();
		wd.quit();
	}
	//��Ԫ�ز���,����л�
	@Test
	public void simpleEle() throws InterruptedException{
		WebDriver wd=new FirefoxDriver();
		String url="http://mail.163.com/";
		String username="zaichangma";
		String password="27japan!!";
		System.out.println("163�����¼");
		wd.get(url);
		Thread.sleep(5000);
		wd.switchTo().frame("x-URS-iframe");
		wd.findElement(By.name("email")).clear();
		wd.findElement(By.name("email")).sendKeys(username);
		wd.findElement(By.name("password")).clear();
		wd.findElement(By.name("password")).sendKeys(password);
		wd.findElement(By.id("dologin")).click();
		//wd.quit();
		//wd.switchTo().defaultContent();
		//wd.findElement(By.linkText("�����ҳ")).click();
	}
}
