package ch08.exam01;

public class Example {

	public static void main(String[] args) {
		int max = RemoteControl.MAX_VOLUME;
		int min = RemoteControl.MIN_VOLUME;
		
		//RemoteControl.turnOn();
		//RemoteControl.turnOff();
		//RemoteControl.setVolume(5);
		
		//RemoteControl.setMute(true);
		
		RemoteControl.changeBattery();
		
		Television tv = new Television();
		tv.turnOn();	// 이건 tv를 직접 사용한 것
		
		RemoteControl rc = tv;
		rc.turnOn();	// 이게 올바른 사용법
		
		
	}

}

// 이 인터페이스를 통해 객체를 생성하면 'RemoteControl 구현 객체' 라고 부른다.
// 구현하다 -> implements