package ch11.exam01;

public class Example {

	public static void main(String[] args) {
		Board b1 = new Board(1, "ah", "hello");
		Board b2 = new Board(1, "ah", "hello");
		
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));
	}

}
