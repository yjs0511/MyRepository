package ch12.exam10;

public class InterruptExample {

	public static void main(String[] args) {
		PrintThread3 pt1 = new PrintThread3();
		
		pt1.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		pt1.interrupt();
	}
}
