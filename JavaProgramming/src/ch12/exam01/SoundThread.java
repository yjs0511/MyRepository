package ch12.exam01;

import java.awt.Toolkit;

public class SoundThread extends Thread {
	// field

	// constructor
	public SoundThread() {
		setName("soundThread");
	}
	// method

	@Override
	public void run() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			tk.beep();
			System.out.println("소리: " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
