package ch06.exam12;

public class StaticMember2 {
	//Static field
	static String field;
	String field2;
	
	//Static block
	static{
		System.out.println("static block 실행");
		field = "자바";
		//field2 = "자바";		// 객체가 없어서 못 쓴다
	}
	
	//Static method
	static void method(){
		//field2 = "자바";		// 객체가 없어서 못씀
	}
	
	void method2(){
		field = "자바";
		field2 = "자바";
	}
	
	public static void main(String[] args){		// 클래스 멤버에 속하지 않는 메소드 (jvm에 의해서 처음 실행될때 호출되는 메소드)
		field = "자바";		// 
		//field2 = "자바";		// 인스턴스 멤버라 사용 못 함
		
		method();
		//method2();	
		
		StaticMember2 sm = new StaticMember2();
		sm.field2 = "자바";
		sm.method2();
	}
}
