package ch06.exam14;

public class PersonExample {

	public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "아이언맨");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		
		//p1.nation = "USA";
		//p1.ssn = "111111111111";
		p1.name ="배트맨";
	}

}
