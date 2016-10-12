package sample.baek;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P6 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		int days = 0;

		String date = sc.nextLine();
		String[] str = date.split(" ");
		
		for (String num : str) {
			list.add(Integer.parseInt(num));
		}
		
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 1; i < list.get(0); i++) {
			days += month[i];
		}

		days += list.get(1);

		switch (days%7) {
		case 0:
			System.out.println("SUN");
			break;
		case 1:
			System.out.println("MON");
			break;
		case 2:
			System.out.println("TUE");
			break;
		case 3:
			System.out.println("WED");
			break;
		case 4:
			System.out.println("THU");
			break;
		case 5:
			System.out.println("FRI");
			break;
		case 6:
			System.out.println("SAT");
			break;
		}
	}
}
