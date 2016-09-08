package ch12.exam13;

public class ThreadGroupExample2 {

	public static void main(String[] args) {
		Thread th;

		th = new Thread("t1") {
			public void run() {
				while (true) {
					System.out.println(getName() + " : 실행중...");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println(getName() + " : 종료");
			}
		};
		
		th.start();
		
		th = new Thread("t2") {
			public void run() {
				while (true) {
					System.out.println(getName() + " : 실행중...");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println(getName() + " : 종료");
			}
		};
		
		th.start();
		
		ThreadGroup sub = new ThreadGroup("sub");
		
		th = new Thread(sub, "t3") {
			public void run() {
				while (true) {
					System.out.println(getName() + " : 실행중...");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println(getName() + " : 종료");
			}
		};
		th.start();
		
		th = new Thread(sub, "t4") {
			public void run() {
				while (true) {
					System.out.println(getName() + " : 실행중...");
					if (isInterrupted()) {
						break;
					}
				}
				System.out.println(getName() + " : 종료");
			}
		};
		th.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		Thread.currentThread().getThreadGroup().interrupt();
	}
}
