package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

public class C {
	//A a = new A();  // 다른 패키지로부터 불러왔기 때문에 안된다.
	
	
	//constructor
	C(){
	//	A a = new A();
	//	a.method();	// 다른 패키지에서 불러오므로 안됨
	}
	
	//method
	void method(){
		/*A a = new A();
		a.field = 10;
		a.method();*/
	}
}
