package depend;

import org.testng.annotations.Test;

public class MethodSkiped {
	@Test
	public void fun1(){
		System.out.println("fun1");
		throw new RuntimeException("fun2应该跳过");
	}
	@Test(dependsOnMethods="fun1")
	public void fun2(){
		System.out.println("fun2");
	}
}
