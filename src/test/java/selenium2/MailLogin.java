package selenium2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailLogin {
	public  static WebDriver driver=null;
	public static void login(WebDriver wd,String email,String password){
		LoginPage.login_Username(wd).sendKeys(email);
		LoginPage.login_Password(wd).sendKeys(password);
		LoginPage.login_Btn(wd).click();
	}
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("http://mail.163.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login(driver,"zaichangma","27JAPAN!!");
		Thread.sleep(3000);
		driver.quit();

	}

}
