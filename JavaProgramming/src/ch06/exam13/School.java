package ch06.exam13;

public class School {
	//field
	private static School singleton = new School();	// 자기 자신의 객체를 만든다
	
	//constructor
	private School(){
		
	}
	
	//method
	static School getInstance(){
		return singleton;
	}
}
