package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import selenium.mail163.PublicModel;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class ImportCSV {
	//导入验证
	@Ignore
	@Test
	public void importCSVTest() throws IOException{
		File file=new File("E:\\selenium2\\src\\test.csv");
		FileInputStream in=new FileInputStream(file);
		CsvReader csvReader=new CsvReader(in, Charset.forName("GBK"));
		//读取表头
//		System.out.println("getHeaders"+csvReader.getHeaders());
		System.out.println(csvReader.get("用户名"));
		while(csvReader.readRecord()){
			//读取一行
			System.out.println("getRawRecord"+csvReader.getRawRecord());
			//读取一列
			System.out.println("get"+csvReader.get(1));
//			System.out.println(csvReader.get("用户名"));
//			System.out.println("getValues"+csvReader.getValues());
			//读取列数
			System.out.println("getColumnCount"+csvReader.getColumnCount());
			
		}
		in.close();

	}
	//导出验证
	@Ignore
	@Test
	public void exportCSVTest() throws Exception{
		File file=new File("E:\\selenium2\\src\\test1.csv");
		FileOutputStream out=new FileOutputStream(file);
		CsvWriter csvWriter=new CsvWriter(out,',',Charset.forName("GBK"));
		String[] headers={"姓名","年龄","联系方式"};
		String[] content1={"lucy","23","18903009821"};
		String[] content2={"lucy","24","18903009822"};
		String[] content3={"lucy","25","18903009823"};
		csvWriter.writeRecord(headers);
		csvWriter.writeRecord(content1);
		csvWriter.writeRecord(content2);
		csvWriter.writeRecord(content3);
		csvWriter.close();
	}
	//使用cvs导入数据进行自动化验证
	@Test 
	public void importCSVTestForAuto() throws Exception{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--start-maximized");
		System.out.println("163邮箱登录");
		String url="http://mail.163.com/";
		WebDriver driver=new ChromeDriver(options);
		driver.get(url);
		File file=new File("E:\\selenium2\\src\\loginInfo.csv");
		FileInputStream in=new FileInputStream(file);
		CsvReader csvReader=new CsvReader(in, Charset.forName("GBK"));
		int count=0;
		while(csvReader.readRecord()){
		count++;
		Thread.sleep(5000);	
		PublicModel.login(driver, csvReader.get(0), csvReader.get(1));
		System.out.println(csvReader.get(2));
		Thread.sleep(10000);
		PublicModel.logout(driver);
		Thread.sleep(5000);
		PublicModel.reLogin(driver);
		}
		System.out.println(count);
		in.close();
	}
}
