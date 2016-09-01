package ch10.exam01;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
			System.out.print("입력 : ");
				String data = sc.nextLine();
				int value = Integer.parseInt(data);

				System.out.println(value);
			} catch (NumberFormatException e) {
				System.out.println("에러 났습니다 ㅋ");
			} finally {
				System.out.println("무조건 실행");
			}
		}
	}
}
