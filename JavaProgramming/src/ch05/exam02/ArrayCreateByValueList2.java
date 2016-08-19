package ch05.exam02;

public class ArrayCreateByValueList2 {

	public static void main(String[] args) {
		// how 1
		int[] scores1 = {83, 90, 87};
		int value1 = 10;
		
		// how 2
		int[] scores2;
		scores2 = new int[] {83, 90, 97};
		
		sum(scores1);
	}
	
	public static void sum(int[] arr){
		
	}
}
