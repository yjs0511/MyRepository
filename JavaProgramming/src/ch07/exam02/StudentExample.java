package ch07.exam02;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동", "132456-1324567", 1);
		
		System.out.println("name : "+s1.name);
		System.out.println("ssn : "+s1.ssn);
		System.out.println("studentNo : "+s1.studentNo);
	}

}
