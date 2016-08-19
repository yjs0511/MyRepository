package ch04.exam02;

import java.io.IOException;

public class WhileExample4 {

	public static void main(String[] args) throws IOException {
		System.out.println("프로그램 시작");
		int num = 0;
		while (num != 113) {
			num = System.in.read();
			/*if (num != 13) {
				if (num != 10) {
					System.out.println(num);
				}
			}*/
			
			/*if(num == 113){
				System.out.println("반복문을 종료합니다.");
				break;
			}*/
			
			if(num != 13 && num != 10){
				System.out.println(num);
			}
		}
		System.out.println("프로그램 종료");
	}

}
