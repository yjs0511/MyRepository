package ch13.exam01;

import java.util.Date;

public class BoxExample {

	public static void main(String[] args) {
		
		Box box1 = new Box();
		
		box1.setItem("홍길동");
		String name = (String) box1.getItem();
		
		Box box2 = new Box();
		box2.setItem(10);	// 자동으로 10이 new Integer(10)으로 boxing 된다
		int value = (Integer) box2.getItem();
		
		Box box3 = new Box();
		box3.setItem(new Date());
		Date now = (Date) box3.getItem();	// String으로 저장할 경우 Date와의 관계가 없기 때문에 cast 예외 발생
	}

}
