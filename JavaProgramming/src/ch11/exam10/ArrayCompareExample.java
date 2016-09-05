package ch11.exam10;

import java.util.Arrays;

public class ArrayCompareExample {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {1, 2, 3};
		
		System.out.println(arr1 == arr2);	//다른 배열이다
		System.out.println(Arrays.equals(arr1, arr2));	
		
		int[][] arr3 = {{1,2},{3,4,5}};
		int[][] arr4 = {{1,2},{3,4,5}};
		
		System.out.println(arr3 == arr4);
		System.out.println(Arrays.equals(arr3, arr4));	// 2차원 배열이 번지를 참조하기 때문에 둘이 참조하는 번지가 다르므로 false
		System.out.println(Arrays.deepEquals(arr3, arr4));	// 2차원 배열의 값 까지 비교한다 따라서 true
	}

}
