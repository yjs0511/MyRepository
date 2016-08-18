package ch04.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		/*for(int i=0; i<100; ){   // for문으로 무한루핑 시킵니다.
			int x = (int)(Math.random()*10)+1;	// x값을 1~10사이의 임의 값을 받습니다.
			int y = (int)(Math.random()*10)+1;  // y값을 1~10사이의 임의 값을 받습니다.
			
			if((4*x + 5*y) == 60){				// 방정식을 만족 시키는 x, y값이 있으면 참
				System.out.println("("+x+", "+y+ ")");	// x, y값을 출력합니다.
			}
		}*/				// 문제는 멈출 수가 없습니다. 어떻게 해야 같은 값이 나오면 지나치게 할 수 있는지 모르겠습니다.
		
		
		
		
		/*for(int x=1; x<=10; x++){		// x값을 1부터 10까지 10번 반복합니다.
			for(int y=1; y<=10; y++){	// y값을 1부터 10까지 10번 반복합니다.
				if((4*x + 5*y) == 60){	// 방정식을 만족 시키는 x, y값이 있으면 참
					System.out.println("("+x+", "+y+ ")");	// x, y값을 출력합니다.
				}
			}
		}*/			// 이중 for문을 사용하여 x, y의 모든 경우를 간단하게 대입시킬 수 있습니다.
					// 이 방법 아직 안 배워서 쓰면 안될 것 같아 주석으로 남깁니다.
		

			for (int y = 1; y <= 10; y++) {		// y값을 1부터 10까지 대입시킵니다.
				int x=1;						// x값을 1로 고정한 후,
				if ((4 * x + 5 * y) == 60) {	// 해당 방정식을 만족 시키면
					System.out.println("(" + x + ", " + y + ")");	// x, y값을 출력합니다.
				}
			}
			
			for (int y = 1; y <= 10; y++) {		// 같은 방식으로 x값만 바꿔 9번을 반복하면 방정식을 만족시키는 값이 언젠가는 나옵니다 ^^.
				int x=2;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=3;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=4;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=5;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=6;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=7;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=8;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=9;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
			
			for (int y = 1; y <= 10; y++) {
				int x=10;
				if ((4 * x + 5 * y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
	}
}
