package ch07.exam04;

public class Robot extends Machine {
	
 	@Override
 	public void work() {
 		super.work();	// 안드로이드에서 많이 나온다.
		System.out.println("Robot-work() 실행");
 	}
}
