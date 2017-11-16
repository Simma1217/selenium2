package selenium.mail163;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PublicModel {
	public static void login(WebDriver driver,String username,String password){
		driver.switchTo().frame("x-URS-iframe");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		//使用登录按钮提交
		driver.findElement(By.id("dologin")).click();
		//返回到上一个iframe
		driver.switchTo().defaultContent();
	}
	public static void logout(WebDriver driver){
		driver.findElement(By.linkText("退出")).click();
	}
}
