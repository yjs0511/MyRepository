package ch09.exam06_important;

public class A {
	//field
	int field = 1;
	
	//constructor
	
	//method
	public void method(){
		final int local = 10;	//final 로 선언 해야한다  (로컬 변수) 
		//local class
		class B {	// public 을 붙이지 못한다. method() 안에서만 사용되기 때문에 접근제한의 의미가 없다.
			// final을 안 붙이면 로컬 변수가 여기에 복제되어 B class의 필드가 된다.
			void method(){
				// 이 위치에 final int local = 10 이 로컬 변수가 복제된다(final로 선언시). 메소드가 끝나도 객체가 사라지면 안되기 때문
				field = 2;
				//local = 5;	// 로컬 변수를 로컬 클래스 내부에서 쓰면 final 속성이 생긴다
							// 위의 값을 그대로 써야한다 (클래스 내부에 local 변수가 복제가 된다)
			}
		}	
	}
	
	public void method2(){
		class B {
			void method(){
				
			}
		}
		B b = new B();
	}
}
