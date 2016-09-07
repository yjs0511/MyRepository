package ch12.exam08;

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject shareObject = new WorkObject();
		
		ThreadA ta = new ThreadA(shareObject);
		ThreadB tb = new ThreadB(shareObject);
		
		ta.start();
		tb.start();
	}

}
