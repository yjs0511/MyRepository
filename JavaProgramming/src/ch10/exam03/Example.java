package ch10.exam03;

public class Example {

	public static void main(String[] args) {
		Account acc = new Account();
		acc.deposit(100000);
		System.out.println(acc.getBalance());
		
		try {
			acc.withdraw(100002);
			System.out.println("출금이 되었습니다.");
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("출금이 되지 않았습니다.");
		}
	}
}
