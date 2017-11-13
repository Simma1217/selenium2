package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example {
	//百度登录
	@Test
	public void loginTest(){
		WebDriver wd=new FirefoxDriver();
		String url="https://www.baidu.com";
		wd.get(url);
	}	
	//登录csdn并下载文件到本地
	@Test
	public void downloadTest(){
		WebDriver wd=new FirefoxDriver();
		String url="https://www.baidu.com";
		wd.get(url);
	}	

}
