package ch07.exam13;

public class SmartPhone extends Phone {
	public void internet(){
		System.out.println("인터넷 사용");
		ring();
	}

	@Override
	public void ring() {
		System.out.println("띠링띠링~");
	}
}
