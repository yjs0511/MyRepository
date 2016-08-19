package ch04.exam02;

public class WhileExample2 {

	public static void main(String[] args) throws InterruptedException {
		int i = 1;
		while(i<=10){
			System.out.println("반복 실행중....");
			Thread.sleep(1000);
			i++;
		}
	}
}
