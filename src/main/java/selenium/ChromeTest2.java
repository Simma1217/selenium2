package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest2 {
	
	@Test
	public void startUp(){
		WebDriver wb=new ChromeDriver();
		wb.get("https://www.baidu.com");
		wb.manage().window().setSize(new Dimension(300,400));
		WebElement text=wb.findElement(By.id("kw"));
		text.sendKeys("hello firefox ,i am selenium");
		WebElement btn=wb.findElement(By.id("kw"));
		btn.click();
		wb.close();
		
	}
}
