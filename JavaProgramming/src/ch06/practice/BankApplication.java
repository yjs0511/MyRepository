package ch06.practice;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		boolean run = true;
		while(run){
			System.out.println("------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------------");
			System.out.println("선택 > ");
			
			String selectNo = sc.nextLine();
			
			if(selectNo.equals("1")){
				createAccount();
			}else if(selectNo.equals("2")){
				accountList();
			}else if(selectNo.equals("3")){
				deposit();
			}else if(selectNo.equals("4")){
				withdraw();
			}else if(selectNo.equals("5")){
				run=false;
			}
		}
	}
	
	//계좌생성
	private static void createAccount(){
		for(int i=0; i<accountArray.length; i++){
			if(accountArray[i] == null){
				System.out.print("계좌번호 : ");
				String ano = sc.nextLine();
				
				System.out.print("계좌주 : ");
				String owner = sc.nextLine();
				
				System.out.print("초기입금액 : ");
				String balance = sc.nextLine();
				
				accountArray[i].setAno(ano);
				accountArray[i].setOwner(owner);
				accountArray[i].setBalance(Integer.parseInt(balance));
				
				System.out.println("결과 : 계좌가 생성되었습니다.");
				break;
			}
			
		}
		
	}
	
	private static void accountList(){
		
	}
	
	//예금하기
	private static void deposit(){
		
	}
	
	//출금
	private static void withdraw(){
		
	}
	
	
	
	
}
