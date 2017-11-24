package param;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CharUtilsTest {

  @Test(dataProvider="dataPro")
  public void CharToASCIITest(char character,int ascii) {
	  int i=CharUtils.CharToASCII(character);
	  Assert.assertEquals(i, ascii);

  }

  @Test(dataProvider="dataPro")
  public void ASCIIToCharTest(char character,int ascii) {
	  char c=CharUtils.ASCIIToChar(ascii);
	  Assert.assertEquals(c, character);
  }
  @DataProvider(name="dataPro")
  public Object[][] dataPro(){
	   return new Object[][]{
	            { 'A', 65 },{ 'a', 97 },
	            { 'B', 66 },{ 'b', 98 },
	            { 'C', 67 },{ 'c', 99 },
	            { 'D', 68 },{ 'd', 100 },
	            { 'Z', 90 },{ 'z', 122 },
	            { '1', 49 },{ '9', 57 }
	        };
  }
}
