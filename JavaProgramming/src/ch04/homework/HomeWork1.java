package ch04.homework;

public class HomeWork1 {

	public static void main(String[] args) {
		for(int i=0; i<100; i++){	// 0~99번 까지 100번 반복합니다.
			int num1 = (int)(Math.random()*6)+1;	// 1~6사이의 임의 정수를 num1 변수에 대입합니다.
			int num2 = (int)(Math.random()*6)+1;	// 1~6사이의 임의 정수를 num2 변수에 대입합니다.
			
			if(num1 + num2 == 10){	// num1 값과 num2 값의 합이 10인 경우
				System.out.println("("+num1+", "+num2+ ")");	// num1 값과 num2 값을 출력한다.
			}
		}
	}
}
