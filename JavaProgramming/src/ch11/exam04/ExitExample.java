package ch11.exam04;

public class ExitExample {

	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager() {
			
			@Override
			public void checkExit(int status) { // exit()가 실행되면 얘가 실행된다. 얘가
												// 정상실행하면 프로세스는 죽는다.
				if (status != 5) {
					
					throw new SecurityException();
				}
				System.out.println("나 죽네~");
			}
		});

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				System.exit(i); // 프로그램을 완전히 종료시킨다.
			} catch (SecurityException e) {

			}

			// break; // for문을 빠져나가라
			// return; // method를 끝내라
		}
	}
}
