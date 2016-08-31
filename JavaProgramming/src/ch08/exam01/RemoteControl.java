package ch08.exam01;

public interface RemoteControl {
	//Constant
	int MAX_VOLUME = 10;	// public static final 이거 생략되있음 일반적으로 안 붙인다
	int MIN_VOLUME = 0;
	
	//Abstract Method
	void turnOn();			// public abstract 가 생략 되있다.
	void turnOff();
	void setVolume(int volume);
	
	//Default Method
	default void setMute(boolean mute){		// public 이 생략
		if(mute == true){
			System.out.println("무음 처리 합니다.");
		}else{
			System.out.println("무음 해제 합니다.");
		}
	}
	
	//Static Method
	static public void changeBattery(){
		System.out.println("건전지를 교환합니다.");
	}
}
