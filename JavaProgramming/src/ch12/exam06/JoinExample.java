package ch12.exam06;

public class JoinExample {

	public static void main(String[] args) {
		SumThread st = new SumThread();
		st.start();
		
		try {
			st.join();
		} catch (InterruptedException e) {}
		System.out.println("1~100 합 : " + st.getSum());
	}

}
