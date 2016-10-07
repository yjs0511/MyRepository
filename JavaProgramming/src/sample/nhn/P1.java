package sample.nhn;

import java.util.Scanner;

public class P1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("홀수 입력 : ");
		int num = sc.nextInt();	// 입력한 숫자
		int mid = (num/2) + 1;
		
		for(int i=0; i<mid; i++){
			for(int j=i; j<mid-1; j++){
				System.out.print(" ");
			}
			
			for(int j=0; j<(2*i+1); j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=mid-1; i>0; i--){
			for(int j=i; j<mid; j++){
				System.out.print(" ");
			}
			
			for(int j=0; j<(2*i-1); j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
