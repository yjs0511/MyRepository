package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) throws InterruptedException {
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++){
			tk.beep();
			Thread.sleep(500);
		}
		
		for(int i=0; i<5; i++){
			System.out.println("띵");
			Thread.sleep(500);
		}
	}
}
