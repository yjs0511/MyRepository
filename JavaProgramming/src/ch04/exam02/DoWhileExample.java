package ch04.exam02;

import java.io.IOException;

public class DoWhileExample {
	
	public static void main(String[] args) throws IOException {
		int num = 0;
		do{
			num = System.in.read();
			System.out.println(num);
		}while(num != 113);
	}
}
