package selenium;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import selenium.mail163.PublicModel;

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
	//登录csdn并下载文件到本地--可以运行，使用chrome更好，但是chrome的参数在哪呢？
	@Ignore
	@Test
	public void downloadTest() throws InterruptedException{
		String downloadFilepath = "E:\\java";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        options.setExperimentalOption("prefs",chromePrefs);
        options.addArguments("--test-type");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver wd=new ChromeDriver(cap);
		String url="https://www.csdn.net/";
		wd.get(url);
		wd.findElement(By.xpath("//*[@id='login']/a[1]")).click();
		//设置等待时间后捕获
		Thread.sleep(2000);	
		wd.findElement(By.xpath("//*[@id='username']")).sendKeys("479921347@qq.com");
		wd.findElement(By.xpath("//*[@id='password']")).sendKeys("27japan!!");
		wd.findElement(By.xpath("//*[@id='fm1']/input[6]")).click();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		WebElement we=wd.findElement(By.cssSelector("body > div.main.clearfix > div.ph_right > div.phr_third.clearfix > div.phr_third_con.tracking-ad > a:nth-child(3)"));
		JavascriptExecutor je=(JavascriptExecutor) wd;
		String href=we.getAttribute("href");
		je.executeScript("window.location.href='"+href+"'");
		Thread.sleep(5000);
		wd.findElement(By.xpath("//*[@id='keywords']")).sendKeys("selenium");
		WebElement search=wd.findElement(By.cssSelector("body > div.home_page_wrap > div.home_banner > div > div.advanced_search > a"));
		Thread.sleep(5000);	
		search.click();
/*		Actions actions=new Actions(wd);
		actions.click(search).perform();*/
/*		System.out.println(search.getText());
		je.executeScript("search_submit()");*/
		Thread.sleep(5000);
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
	//模拟发邮件
	@Test
	public void sendEmail() throws Exception{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized");
		System.out.println("163邮箱登录");
		String url="http://mail.163.com/";
		WebDriver driver=new ChromeDriver(options);
		driver.get(url);
		String username="zaichangma";
		String password="27japan!!";
		Thread.sleep(5000);
		PublicModel.login(driver, username, password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='_mail_component_70_70']/span[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("479921347@qq.com");
		driver.findElement(By.xpath("//*[@id='1510818939631_subjectInput']")).sendKeys("测试163邮箱发送");
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='1510818939631_subjectInput']")));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id='_mail_button_9_263']/span[2]")).click();


		
		
		//PublicModel.logout(driver);

	}

}
