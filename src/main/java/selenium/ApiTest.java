package selenium;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ApiTest {
	@Ignore
	//浏览器的前进后退
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
	//简单元素操作,多表单切换
	@Ignore
	@Test
	public void simpleEle() throws InterruptedException{
		WebDriver wd=new FirefoxDriver();
		String url="http://mail.163.com/";
		String username="zaichangma";
		String password="27japan!!";
		System.out.println("163邮箱登录");
		wd.get(url);
		Thread.sleep(5000);
		wd.switchTo().frame("x-URS-iframe");
		wd.findElement(By.name("email")).clear();
		wd.findElement(By.name("email")).sendKeys(username);
		wd.findElement(By.name("password")).clear();
		wd.findElement(By.name("password")).sendKeys(password);
		//使用登录按钮提交
		wd.findElement(By.id("dologin")).click();
		//wd.quit();
		//返回到上一个iframe
		//wd.switchTo().defaultContent();
		//wd.findElement(By.linkText("邮箱黄页")).click();
	}
	//简单元素操作
	@Ignore
	@Test
	public void simpleEle2() throws InterruptedException{
		WebDriver wd=new FirefoxDriver();
		String url="http://www.youdao.com";
		wd.get(url);
		Thread.sleep(3000);
		//使用submit方法
		wd.findElement(By.id("translateContent")).sendKeys("password");
		wd.findElement(By.id("translateContent")).submit();
	}
	//简单元素操作
	@Ignore
	@Test
	public void simpleEle3() throws InterruptedException{
		WebDriver wd=new FirefoxDriver();
		String url="https://www.baidu.com";
		wd.get(url);
		//获得百度输入框的尺寸
		System.out.println("百度输入框的尺寸:"+wd.findElement(By.id("kw")).getSize());
		//返回元素的属性值，可以是 id、name、type 或元素拥有的其它任意属性
		System.out.println("元素的属性值id:"+wd.findElement(By.id("kw")).getAttribute("id"));
		System.out.println("元素的属性值name:"+wd.findElement(By.id("kw")).getAttribute("name"));
		System.out.println("元素的属性值type:"+wd.findElement(By.id("kw")).getAttribute("type"));
		//返回元素的结果是否可见，返回结果为 True 或 False
		System.out.println("返回元素的结果是否可见:"+wd.findElement(By.id("kw")).isDisplayed());
	}
	//获取本地文件打开，简单元素操作
		@Ignore
		@Test
		public void simpleEle4() throws InterruptedException{
			WebDriver wd=new FirefoxDriver();
			wd.get("file:///E:/seleniumhtmltest/simpleEleCheckbox.html");
			Thread.sleep(2000);
			List<WebElement> eles=wd.findElements(By.tagName("input"));
			for(WebElement ele:eles){
				String type=ele.getAttribute("type");
				//勾选所有多选框
				if(type.equals("checkbox")){
					ele.click();
				}
			}
			}
	//获取本地文件打开，使用form的submit提交
	@Ignore
	@Test
	public void findLocalFile() throws InterruptedException{
		WebDriver wd=new FirefoxDriver();
		wd.get("file:///e:/seleniumhtmltest/simpleEle.html");
		Thread.sleep(2000);
		wd.findElement(By.id("uname")).sendKeys("simma");
		wd.findElement(By.id("psw")).sendKeys("123456");
		wd.findElement(By.id("formID")).submit();
	}
	//鼠标操作，悬停
		@Ignore
		@Test
		public void mouseAction() throws InterruptedException{
			WebDriver wd=new FirefoxDriver();
			String url="https://www.baidu.com";
			wd.get(url);
//			System.out.println(wd.findElement(By.xpath("//*[@id='u1']/a[8]")).getText());
//			wd.findElement(By.xpath("//*[@id='u1']/a[8]")).click();
			Actions action=new Actions(wd);
			//可用使用moveToElement或者clickAndHold
//			action.moveToElement(wd.findElement(By.xpath("//*[@id='u1']/a[8]"))).perform();
			action.clickAndHold(wd.findElement(By.xpath("//*[@id='u1']/a[8]"))).perform();
			//使用linktext获取不到元素
			action.clickAndHold(wd.findElement(By.linkText("设置"))).perform();
			
		}
		//鼠标操作，悬停
		@Ignore
		@Test
		public void keyboardAction() throws InterruptedException{
			WebDriver wd=new FirefoxDriver();
			String url="https://www.baidu.com";
			wd.get(url);
			WebElement input=wd.findElement(By.id("kw"));
			input.sendKeys("seleniumm");
			input.sendKeys(Keys.BACK_SPACE);
			input.sendKeys(Keys.CONTROL,"a");
			input.sendKeys(Keys.CONTROL,"x");
			input.sendKeys(Keys.CONTROL,"v"); 
			input.sendKeys(Keys.CONTROL,"v"); 		
			input.sendKeys(Keys.ENTER); 					
		}
		//获取验证信息
		@Ignore
		@Test
		public void validate() throws Exception{
			WebDriver wd=new FirefoxDriver();
			String url="http://mail.163.com/";
			String username="zaichangma";
			String password="27japan!!";
			wd.get(url);
			System.out.println("登录之前地址为："+wd.getCurrentUrl()+"登录前的网址标题为："+wd.getTitle());
			Thread.sleep(5000);
			wd.switchTo().frame("x-URS-iframe");
			wd.findElement(By.name("email")).clear();
			wd.findElement(By.name("email")).sendKeys(username);
			wd.findElement(By.name("password")).clear();
			wd.findElement(By.name("password")).sendKeys(password);
			//使用登录按钮提交
			wd.findElement(By.id("dologin")).click();
			//*****必须退出原先的frame再进行操作，否则就是#！@￥！@
			wd.switchTo().defaultContent();
			Thread.sleep(10000);
			System.out.println("登录之后地址为："+wd.getCurrentUrl()+"登录后的网址标题为："+wd.getTitle());
			String text=wd.findElement(By.id("spnUid")).getText();
			System.out.println("登录之后的用户名位置显示："+text);
		}
		//设置元素等待
		@Ignore
		@Test
		public void waitTest() throws Exception{
			WebDriver wd=new FirefoxDriver();
			String url="http://mail.163.com/";
			//设置页面的加载时间为2秒
//			wd.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
			String username="zaichangma";
			String password="27japan!!";
			wd.get(url);
			System.out.println("登录之前地址为："+wd.getCurrentUrl()+"登录前的网址标题为："+wd.getTitle());
			Thread.sleep(5000);
			wd.switchTo().frame("x-URS-iframe");
			wd.findElement(By.name("email")).clear();
			wd.findElement(By.name("email")).sendKeys(username);
			wd.findElement(By.name("password")).clear();
			wd.findElement(By.name("password")).sendKeys(password);
			//使用登录按钮提交
			wd.findElement(By.id("dologin")).click();
			//*****必须退出原先的frame再进行操作，否则就是#！@￥！@
			wd.switchTo().defaultContent();
			Thread.sleep(10000);
			System.out.println("登录之后地址为："+wd.getCurrentUrl()+"登录后的网址标题为："+wd.getTitle());
			wd.manage().timeouts().implicitlyWait(1,TimeUnit.NANOSECONDS);
			String text=wd.findElement(By.id("spnUid0033")).getText();
			System.out.println("登录之后的用户名位置显示："+text);
		}
		//多窗口切换
		@Test
		public void windowsSwitch()	throws InterruptedException{
				WebDriver wd=new FirefoxDriver();
				String url="https://www.baidu.com";
				wd.get(url);
				Actions action=new Actions(wd);
				action.contextClick(wd.findElement(By.linkText("新闻"))).perform();
		}
}