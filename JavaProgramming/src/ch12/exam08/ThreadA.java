package ch12.exam08;

public class ThreadA extends Thread {
	private WorkObject wo;		// 주입(외부에서 객체를 받아서 내부에 주입 = injection)
	
	public ThreadA(WorkObject wo) {
		super();
		this.wo = wo;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			wo.methodA();
		}
	}
}
