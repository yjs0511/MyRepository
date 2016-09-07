package ch12.exam11;

public class DaemonExample {

	public static void main(String[] args) {
		AutuSavethread as = new AutuSavethread();
		as.setDaemon(true);
		as.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("메인 스레드 종료");
	}

}
