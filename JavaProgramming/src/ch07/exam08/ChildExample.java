package ch07.exam08;

public class ChildExample {

	public static void main(String[] args) {
		Child c1 = new Child();
		
		c1.method1();
		c1.method2();
		c1.method3();
		
		System.out.println();
		Parent p1 = c1;
		p1.method1();
		p1.method2();
		//p1.method3();
	}

}
