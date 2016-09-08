package ch13.exam05;

public class Util {
	public static <T> Box <T> boxing(T t){	//제네릭 타입으로 T를 쓰겠다
		Box<T> box = new Box<>();
		box.setItem(t);
		return box;
	}
	
	
}
