package ch07.exam01;

public class Machine {
	//field
	public String kind;
	public String maker;
	
	//constructor
	public Machine(){
		System.out.println("Machine 실행됨");
	}
	
	//method
	public void turnOn(){
		System.out.println(maker + " : " + kind + " 파워 온");
	}
	public void turnOff(){
		System.out.println(maker + " : " + kind + " 파워 오프");
	}
}
