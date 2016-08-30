package ch07.exam13;

public abstract class Phone {
	public String number;
	
	public abstract void ring();	// 무조건 재정의 해야됨
	
	public void sendVoice(){
		System.out.println("음성 전송");
	}
	
	public void receiveVoice(){
		System.out.println("음성 수신");
	}
}
