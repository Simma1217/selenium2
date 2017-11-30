package cn.simma.ide;
/** * @author  Simma  
 *@date  创建时间：2017年11月30日 下午12:52:30
 * @version 1.0 
 * @parameter   
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
	
	@Test
	public void startUp(){
		WebDriver wb=new FirefoxDriver();
		wb.get("https://www.baidu.com");
		WebElement text=wb.findElement(By.id("kw"));
		text.sendKeys("hello firefox ,i am selenium");
		WebElement btn=wb.findElement(By.id("kw"));
		btn.click();
//		wb.close();
	}
}

