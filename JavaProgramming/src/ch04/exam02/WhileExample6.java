package ch04.exam02;

import java.io.IOException;

public class WhileExample6 {

	public static void main(String[] args) throws IOException {
		boolean run = true;
		int balance = 0;
		int keyCode = 0;

		while (run) {
			
			if (keyCode != 13 && keyCode != 10) {
				System.out.println("--------------------------");
				System.out.println("1.예금 | 2.출금 | 3.종료");
				System.out.println("--------------------------");
			
				System.out.print("선택 : ");
			}
				
			keyCode = System.in.read();
			
			if (keyCode == 49) {
				System.out.println("1000원 예금합니다.");
				balance += 1000;
				System.out.println("현재 잔액 : " + balance + "원");
			} else if (keyCode == 50) {
				System.out.println("500원 출금합니다.");
				balance -= 500;
				System.out.println("현재 잔액 : " + balance + "원");
			} else if (keyCode == 51) {
				run = false;
			}
		}
	}
}
