package ch07.exam13;

public class Example {
	
	public static void main(String[] args) {
		
		SmartPhone p1 = new SmartPhone();
		p1.number = "010-123-1234";
		p1.ring();
		p1.sendVoice();
		p1.receiveVoice();
		
	}
}