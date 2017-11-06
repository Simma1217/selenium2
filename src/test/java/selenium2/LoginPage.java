package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element =null;
	public static WebElement login_Username(WebDriver wd){
			element= wd.findElement(By.name("email"));
			return element;
	}
	public static WebElement login_Password(WebDriver wd){
		element= wd.findElement(By.name("password"));
		return element;
}
	public static WebElement login_Btn(WebDriver wd){
		element= wd.findElement(By.id("dologin"));
		return element;
}
}
