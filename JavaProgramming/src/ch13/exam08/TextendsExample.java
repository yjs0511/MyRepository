package ch13.exam08;

public class TextendsExample {
	public void method1(C1<Integer> arg){}
	public void method2(C1<? extends Number> arg){}
	public C1<? extends Number> method3(){return null;}	// C1 타입이 이미 정의가 되 있기에 사용가능하다.
	//public C1<T extends Number> method3(){return null;}
}

class C1<T>{}	// 여기서 T를 정의한다.

class C2<T extends Number>{}

class C3{
	public<T> void method(T t){}
	public<T extends Number> void method(T t){}
}
