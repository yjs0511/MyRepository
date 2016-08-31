package ch08.exam01;

public class Television implements RemoteControl{

	@Override		// 인터페이스의 내용이 설명한대로 작성되어있는지 컴파일러가 검사
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		System.out.println("현재 TV 볼륨 : "+ volume);
	}
	
	

}
