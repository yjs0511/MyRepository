package ch11.exam05;

public class GcExample {

	public static void main(String[] args) {
		Employee emp = new Employee(1);
		emp = null;
		emp = new Employee(2);
		emp = new Employee(3);
		System.gc();	// 시스템이 한가할 때 이 작업을 한다.
		
		
	}

}
