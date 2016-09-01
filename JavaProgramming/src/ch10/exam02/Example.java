package ch10.exam02;

public class Example {

	public static void main(String[] args) {
		try{
		int result = Calculator.sum("10", "aa");
		System.out.println(result);
		}catch(Exception e){
			System.out.println("틀렸어 임마");
		}
	}
}
