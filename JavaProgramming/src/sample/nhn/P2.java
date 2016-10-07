package sample.nhn;

import java.util.*;

public class P2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();	// 입력한 숫자
		
		for(int i=num; i>0; i--){
			for(int j=i; j<num; j++){
				System.out.print(" ");
			}
			
			for(int j=0; j<2*i-1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=0; i<num-1; i++){
			for(int j=i+1; j<num-1; j++){
				System.out.print(" ");
			}
			
			for(int j=-2; j<2*i+1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
