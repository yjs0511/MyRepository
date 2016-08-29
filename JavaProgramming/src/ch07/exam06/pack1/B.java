package ch07.exam06.pack1;

public class B {
	//field
	/*A a;
	a = new A();*/	// 클래스 블록은 선언문만 올 수 있다
					// 이것은 실행문이기 때문에 될 수 없다.
	
	A a = new A();  // 이것은 선언문이다.
	
	
	//constructor
	B(){
		A a = new A();
		a.method();
	}
	
	//method
	void method(){
		A a = new A();
		a.field = 10;
		a.method();
	}
}
