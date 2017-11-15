package selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class Example {
	//百度登录
	@Ignore
	@Test
	public void loginTest(){
		WebDriver wd=new FirefoxDriver();
		String url="https://www.baidu.com";
		wd.get(url);
		wd.findElement(By.xpath("//*[@id='u1']/a[7]")).click();
		//设置等待时间后捕获
		wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		wd.findElement(By.xpath("//*[@id='TANGRAM__PSP_10__userName']")).sendKeys("18903009820");
		wd.findElement(By.xpath("//*[@id='TANGRAM__PSP_10__password']")).sendKeys("stronger1101");
		System.out.println(wd.manage().getCookies());
		wd.findElement(By.xpath("//*[@id='TANGRAM__PSP_10__submit']")).click();

		
	}	
	//登录csdn并下载文件到本地
	@Test
	public void downloadTest() throws InterruptedException{
//		FirefoxProfile fp=new FirefoxProfile();
//		fp.setPreference("browser.download.folderList",2);
//		fp.setPreference("browser.download.manager.showWhenStarting",false);
//		fp.setPreference("browser.download.dir","e:\\java");
//		fp.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
//		FirefoxOptions fo=new FirefoxOptions();
//		fo.setProfile(fp);
		WebDriver wd=new FirefoxDriver();
		String url="https://www.csdn.net/";
		wd.get(url);
		wd.findElement(By.xpath("//*[@id='login']/a[1]")).click();
		//设置等待时间后捕获
		Thread.sleep(5000);	
		wd.findElement(By.xpath("//*[@id='username']")).sendKeys("479921347@qq.com");
		wd.findElement(By.xpath("//*[@id='password']")).sendKeys("27japan!!");
		wd.findElement(By.xpath("//*[@id='fm1']/input[6]")).click();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		WebElement we=wd.findElement(By.cssSelector("body > div.main.clearfix > div.ph_right > div.phr_third.clearfix > div.phr_third_con.tracking-ad > a:nth-child(3)"));
		JavascriptExecutor je=(JavascriptExecutor) wd;
		String href=we.getAttribute("href");
		je.executeScript("window.location.href='"+href+"'");
		Thread.sleep(10000);
		wd.findElement(By.xpath("//*[@id='keywords']")).sendKeys("selenium");
		WebElement search=wd.findElement(By.cssSelector("body > div.home_page_wrap > div.home_banner > div > div.advanced_search > a"));
		Thread.sleep(10000);	
		search.click();
/*		Actions actions=new Actions(wd);
		actions.click(search).perform();*/
/*		System.out.println(search.getText());
		je.executeScript("search_submit()");*/
		Thread.sleep(10000);
		String w1=wd.getWindowHandle();
		System.out.println(w1);
		wd.findElement(By.cssSelector("body > div.meeting_main > div.download_new.clearfix > div.download_l.fl > div:nth-child(3) > div.album_detail_wrap > dl:nth-child(1) > dd > a")).click();;
		Thread.sleep(5000);	
		Set<String> ws=wd.getWindowHandles();
		for(String handle:ws){
			if(!handle.equals(w1)){
				wd.switchTo().window(handle);
			}
		}
		System.out.println(wd.getWindowHandle());
		wd.findElement(By.linkText("VIP下载")).click();
		Thread.sleep(2000);	
		wd.findElement(By.xpath("//*[@id='vip_btn']")).click();
	}	

}
