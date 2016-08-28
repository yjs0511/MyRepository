package ch06.exam12;

public class StaticMember {
	//Static field
	static String field;
	
	//Static block
	static{
		System.out.println("static block 실행");
		field = "자바";
	}
	
	//Static method
	static void method(){}
}
