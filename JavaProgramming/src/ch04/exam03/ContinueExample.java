package ch04.exam03;

public class ContinueExample {

	public static void main(String[] args) throws Exception {
		// 키보드로부터 1~3 사이의 번호 이외의 
		// 번호가 입력되면 다시 입력을 하도록 하세요.
		while(true){
			int num = System.in.read();
			if(num < 49 || num > 51){
				continue;
			}
			System.out.println(num);
		}
	}
}
