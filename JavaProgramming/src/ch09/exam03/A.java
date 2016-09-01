package ch09.exam03;

public class A {
	//field
	
	//constructor
	
	//method
	public void method(){
		class B {	// public 을 붙이지 못한다. method() 안에서만 사용되기 때문에 접근제한의 의미가 없다.
			
		}
	}
	
	public void method2(){
		class B {
			//field
			
			//constructor
			
			//method
		}
		B b = new B();
	}
}
