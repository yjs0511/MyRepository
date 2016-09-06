package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample2 {

	public static void main(String[] args) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Thread thread = new Thread(new Runnable(){	// 작업 스레드가 실행

			@Override
			public void run() {
				for(int i=0; i<5; i++){
					tk.beep();
					System.out.println("소리: "+Thread.currentThread().getName());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {	}
				}
			}
			
		});
		
		thread.start();
		
		for(int i=0; i<5; i++){		// 얘는 메인 스레드가 실행
			System.out.println("띵");
			System.out.println("출력: "+Thread.currentThread().getName());
			try {
				
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
