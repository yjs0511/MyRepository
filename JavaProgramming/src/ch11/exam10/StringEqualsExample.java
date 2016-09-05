package ch11.exam10;

public class StringEqualsExample {

	public static void main(String[] args) {
		String strVal1 = "홍길동";	// 리터럴(코드상에서 주는 값)이 같으면 같은 객체를 참조
		String strVal2 =new String("홍길동");	// 
		
		System.out.println(strVal1 == strVal2);
		System.out.println(strVal1.equals(strVal2));
	}

}
