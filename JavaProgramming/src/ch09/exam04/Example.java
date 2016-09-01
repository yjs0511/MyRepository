package ch09.exam04;

public class Example {

	public static void main(String[] args) {
		//B b = new B();
		A a = new A(0);
		A.B b = a.new B();	// a 객체안의 B 생성자를 호출한다
		
		b.field1 = 10;
		b.method1();
	}

}
