package ch12.exam02;

public class ThreadC extends Thread {
	
	public ThreadC(int num){
		setName("ThreadC-" + num);
		
	}
	
	@Override
	public void run() {
		for(int i=1; i<1000000000; i++){
			String str = "a";
			str += "C";
			str += "D";
		}
		System.out.println(getName() + " 종료");
	}
}
