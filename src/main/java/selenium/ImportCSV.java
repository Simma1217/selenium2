package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.Test;

import com.csvreader.CsvReader;

public class ImportCSV {
	//导入验证
	@Test
	public void importCSVTest(){
		File file=new File("/");
		FileInputStream in=new FileInputStream(file);
		CsvReader csvReader=new CsvReader(in, Charset.forName("UTF-8"));
		csvReader.
	}
	//导出验证
	@Test
	public void exportCSVTest(){
		
	}
	//使用cvs导入数据进行自动化验证
	@Test 
	public void importCSVTestForAuto(){
		
	}
}
