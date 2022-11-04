package my.aoptest;

public class HelloAdvice 
{
	public String testA() {
		System.out.println("test A Call");
		return "testA return";
	}
	public void testB() {
		System.out.println("test B Call");
	}
	public String method1() {
		System.out.println("method1 Call");
		return "method1 return";
	}	
}