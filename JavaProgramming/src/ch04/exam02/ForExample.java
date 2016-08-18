package ch04.exam02;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		double avg = 0;
		for(int i=1; i<=3; i++){
			int num = (int) (Math.random()*6) +1;
			sum+=num;
			System.out.println(num);
		}
		avg = sum / 3;
		System.out.println("합계 : "+ sum +", 평균 : "+ avg );
	}

}
