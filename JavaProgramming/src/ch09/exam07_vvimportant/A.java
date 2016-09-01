package ch09.exam07_vvimportant;

public class A {
	int field = 5;	// A의 필드
	
	public void method(){
		this.field = 11;
		class B {
			int field = 2;	// B의 필드
			B(){
				field = 20;
				this.field = 30;
				A.this.field = 1;
			}
		}	
		B b = new B();
		System.out.println("B의 필드 : "+b.field);
		System.out.println("A의 필드 : "+field);
	}
}
