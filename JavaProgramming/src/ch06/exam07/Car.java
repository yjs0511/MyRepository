package ch06.exam07;

public class Car {
	//field
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//constructor
	Car(){
		
	}
	
	Car(String model){
		this.model = model;
	}
	
	Car(String model, String color){
		this.model = model;
		this.color = color;
	}
	
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
