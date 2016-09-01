package ch09.exam04;

public class A {
	//field
	int field;
	
	//constructor
	public A(int field) {
		this.field = field;
		B b = new B();	// A 객체가 존재하기에 이게 가능하다
	}
	
	//method
	void method(){
		B b = new B();
	}
	
	static void method2(){
		//B b = new B();	// 정적 멤버는 객체 없이도 사용되야 하기 때문에 이렇게 쓰면 안된다
	}
	
	//nested(inner) class	중첩 클래스
	
	public class B{
		//field
		int field1;
		
		//static int field2;	// A로 만든 객체를 통해서만 접근할 수 있기 때문에 정적 멤버는 가질 수 없다.
		
		//constructor
		
		//method
		void method1(){};
		
	}
}
