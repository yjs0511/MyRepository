package ch05.exam02;

public class ArrayCreateByValueList1 {

	public static void main(String[] args) {
		int[] scores = {83, 90, 87};
		
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		//System.out.println(scores[3]);
		
		int arrayLength = scores.length;
		System.out.println(arrayLength);
		
		for(int i=0; i<arrayLength; i++){
			System.out.println(scores[i]);
		}
		
		int sum = 0;
		for(int i=0; i<scores.length; i++){
			sum += scores[i];
		}
		System.out.println("총 합 : "+sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("평균 : "+avg);
	}
	
}
