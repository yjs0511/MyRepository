package ch09.aaaa;

public class A {
	//field
	
	//constructor
	
	//method
	public void method(){
		class B {	// public 을 붙이지 못한다. method() 안에서만 사용되기 때문에 접근제한의 의미가 없다.
			
		}
	}
	
	public void method2(){
		
		int value = 1;	//final 특성을 가진다.
		//value = 3;	// 여기서 잘못됬다 이렇게 하면 안된다.
		
		class B {
			//field
			
			//constructor
			
			//method
			public void method2(){
				//value = 3; 이거 안되요~
				int result = value + 1;
				System.out.println(result);
			}
		}
		B b = new B();
		b.method2();
	}
}
