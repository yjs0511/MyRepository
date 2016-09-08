package ch13.exam02;

import java.util.Date;

public class BoxExample {

	public static void main(String[] args) {
		
		Box <String> box1 = new Box<>();
		
		box1.setItem("홍길동");
		String name = box1.getItem();
		
		Box<Integer> box2 = new Box<>();
		box2.setItem(10);	// 자동으로 10이 new Integer(10)으로 boxing 된다
		int value = box2.getItem();
		
		Box<Date> box3 = new Box<>();
		box3.setItem(new Date());
		Date now = box3.getItem();	// String으로 저장할 경우 Date와의 관계가 없기 때문에 cast 예외 발생
		
	}
}
