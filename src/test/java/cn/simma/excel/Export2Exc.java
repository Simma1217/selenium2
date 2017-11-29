package cn.simma.excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

public class Export2Exc {
	@Test
	public void export2(){
		
	}
	@Test
	public void importFrom() throws Exception{
		
		FileInputStream fis=new FileInputStream(new File("E:\\selenium2\\src\\导入测试.xlsx"));
		Workbook wb=new HSSFWorkbook(fis);
	}
}
