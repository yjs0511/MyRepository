package ch02.exam01; // 패키지 선언(전부 소문자로 사용하는게 관례)

public class VariableScope {
	// 클래스는 첫자는 대문자 다음 단어도 첫자는 대문자가 관례 (파일명과 동일)
	public static void main(String[] ar) {
		int var1 = 10;
		System.out.println("var1= " + var1);
		// '+' 는 숫자와 문자열을 결함하는데 사용되기도 한다.

		if (true) {
			int var2 = 15;
			System.out.println("var1 = " + var1);
			System.out.println("var2 = " + var2);
			if(true){
				int var3 = 20;
				System.out.println("var1 = "+var1);	
				System.out.println("var2 = "+var2);	
				System.out.println("var3 = "+var3);	
			}
			System.out.println("var2 = "+var2);	
			//System.out.println("var3 = "+var3);	
		}
		System.out.println("var1 = "+var1);	
//		System.out.println("var2 = "+var2);	

	}
}
