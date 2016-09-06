package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample4 {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Thread thread = new SoundThread();
		thread.start();
		
		for(int i=0; i<5; i++){		// 얘는 메인 스레드가 실행
			System.out.println("띵");
			System.out.println("출력: "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
}
