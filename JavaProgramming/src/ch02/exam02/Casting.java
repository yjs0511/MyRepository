package ch02.exam02;

public class Casting {

	public static void main(String[] args) {
		long v1 = 127;
		int v2 = (int) v1;
		System.out.println("v2 = "+v2);
		
		byte v3 = (byte) v1;
		System.out.println("v3 = "+v3);
		
		char v5 = 'A';  // 2byte
		int v6 = 'A';  // 이렇게 해도 된다 유니코드로 저장되므로
		int v7 = '한';
		//byte v7 = 'A';
		
		System.out.println("v5 = "+v5);
		System.out.println("v6 = "+v6);
		System.out.println("v7 = "+v7);
		
		int v8 = 65;
		char v9 = (char) v8;
		System.out.println("v9 = "+v9);
		
		char v10 =66;
		System.out.println("v10 = "+v10);
	}

}
