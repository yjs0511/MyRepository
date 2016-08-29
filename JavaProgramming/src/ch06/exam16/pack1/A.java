package ch06.exam16.pack1;

public class A {
	//field
	private int field1;	// 비공개
	int field2;	// 같은 패키지에서만 사용 가능
	public int field3;	// 공개
	
	//constructor
	private A(){
		
	}
	A(int field1){}
	
	public A(int field2, int field3){}
	
	//method
	private void method1(){
		
	}
	void method2(){}
	
	public void method3(){}
}
