package depend;

import org.testng.annotations.Test;

/** * @author  Simma  
 *@date  创建时间：2017年11月21日 下午3:30:49
 * @version 1.0 
 * @parameter   
 */
public class MethodPassed {
	@Test
	public void fun1(){
		System.out.println("fun1");
	}
	@Test(dependsOnMethods="fun1")
	public void fun2(){
		System.out.println("fun2");
	}
}

