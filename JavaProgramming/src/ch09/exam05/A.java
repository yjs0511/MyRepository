package ch09.exam05;

public class A {
	
	int field = 10;
	static int field2 = 5;
	
	public A(){
		B b = new B();
	}
	
	void method(){
		B b = new B();
	}
	
	static void method2(){
		B b = new B();
	}
	
	static B b = new B();

	public static class B{
		int field1;
		static int field2;
		
		//static int field2;	// A로 만든 객체를 통해서만 접근할 수 있기 때문에 정적 멤버는 가질 수 없다.
		
		static B b = new B();
		
		void method(){
			B b = new B();
		}
		
		static void method2(){
			B b = new B();
		}
		
		void method1(){		// 얜 
			//field = 3;	// A 객체가 있어야만 사용할 수 있는 필드이기 때문
			field2 = 2;
		};
		
	}
}
