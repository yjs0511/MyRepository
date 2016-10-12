package sample.baek;

import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		if (num <= 100000) {

			for (int i = 0; i < num; i++) {
				System.out.println(num - i);
			}
		}
	}
}
