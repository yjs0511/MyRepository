package ch05.exam02;

public class ArrayReferenceCompare {

	public static void main(String[] args) {
		String[] names = new String[3];
		names[0] = "홍길동";	// 직접 입력한 것을 리터럴이라 한다.
		names[1] = "홍길동";	
		names[2] = new String("홍길동");	
		
		System.out.println(names[0] == names[1]);
		System.out.println(names[0] == names[2]);
		
		System.out.println(names[0].equals(names[1]));
		System.out.println(names[0].equals(names[2]));
	}

}
