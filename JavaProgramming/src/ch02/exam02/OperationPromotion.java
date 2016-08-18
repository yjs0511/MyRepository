package ch02.exam02;

public class OperationPromotion {

	public static void main(String[] args) {
		int v1 = 10 + 20;
		System.out.println("v1 = "+v1);
		
		byte v2 = 10;
		byte v3 = 20;
		//int v4 = v2 + v3;
		byte v5 =(byte)( v2 + v3 ); // 연산이 되면 1바이트도 4바이트(int)로 변경된다
		System.out.println("v5 = "+v5);
		
		char v6 = 'A';
		int v7 = v6 + 1;
		char v8 = (char) v7;
		System.out.println("v8 = "+v8);		
	}

}
