package ch09.exam05;

public class Example {
	public static void main(String[] args){
		A.B.field2 = 10;
		A.B.method2();
		
		A.B b = new A.B();
		b.field1 = 10;
		b.method1();
	}
}
