package ch18.exam08;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner1.nextLine();	// 입력 대기 (엔터 칠 때까지)
		
		System.out.print("나이 : ");
		int age = scanner1.nextInt();
		
		System.out.print("키 : ");
		double height = scanner1.nextDouble();
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		
	}

}
