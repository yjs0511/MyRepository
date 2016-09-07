package ch12.exam13;

public class ThreadGroupExample {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName());

		for (int i = 0; i < 10; i++) {	// 익명 객체 안에서 로컬 변수를 쓰면 final 특성을 갖게 된다.
			int count = i;
			Thread t2 = new Thread() {
				@Override
				public void run() {
					while (true) {
						System.out.println("thread" + count + " : 실행중...");
						if (isInterrupted()) {
							break;
						}
					}
					System.out.println("thread" + count + " : 종료");
				}
			};

			t2.start();
		}

		ThreadGroup mainGroup = t.getThreadGroup();
		mainGroup.getName();
		System.out.println(mainGroup.getName());
		System.out.println(mainGroup.activeCount());

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}

		mainGroup.interrupt();
	}

}
