package ch04.exam02;

import java.io.IOException;

public class WhileExample3 {

	public static void main(String[] args) throws IOException {
		while (true) {
			int num = System.in.read();
			
			/*if (num != 13) {
				if (num != 10) {
					System.out.println(num);
				}
			}*/
			
			if(num != 13 && num != 10){
				System.out.println(num);
			}
		}
	}

}
