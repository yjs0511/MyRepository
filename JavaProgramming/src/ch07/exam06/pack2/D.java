package ch07.exam06.pack2;

import ch07.exam06.pack1.A;

public class D extends A {
	//field
	//A a = new A();	// 이건 상속받아온 게 아니다.
						// default의 특성 때문에 안됨
	
	//constructor
	D(){
		/*A a = new A();	// 상속받아 온 거 아님
		a.field = 1;
		a.method();*/
		
		super();	// 이걸 허용해 준다.
		
		field = 5;	// 이게 상속(상속의 경우 default의 특성이 생기지 않는다)
		method();	// 얘도
	}
	
	//method
	void method2(){
		//A a = new A();	// 상속 관련 없는 코드
		field = 5;	// 이게 상속
		method();	// 얘도
	}
}
