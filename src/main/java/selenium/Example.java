package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

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
		FirefoxProfile fp=new FirefoxProfile();
		fp.setPreference("browser.download.folderList",2);
		fp.setPreference("browser.download.manager.showWhenStarting",false);
		fp.setPreference("browser.download.dir","e:\\java");
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		FirefoxOptions fo=new FirefoxOptions();
		fo.setProfile(fp);
		WebDriver wd=new FirefoxDriver(fo);
		String url="https://www.csdn.net/";
		wd.get(url);
		wd.findElement(By.xpath("//*[@id='login']/a[1]")).click();
		//设置等待时间后捕获
		wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		wd.findElement(By.xpath("//*[@id='username']")).sendKeys("479921347@qq.com");
		wd.findElement(By.xpath("//*[@id='password']")).sendKeys("27japan!!");
		wd.findElement(By.xpath("//*[@id='fm1']/input[6]")).click();
		Thread.sleep(10000);
		wd.findElement(By.linkText("下载")).click();
		wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		wd.findElement(By.xpath("//*[@id='keywords']")).sendKeys("selenium");
		wd.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[1]/a")).click();
		wd.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[3]/div[2]/dl[1]/dd/a")).click();;
		wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		
		wd.findElement(By.xpath("//*[@id='download_top']/div[4]/a[2]")).click();
		wd.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);		
		wd.findElement(By.xpath("//*[@id='vip_btn']")).click();
	}	

}
