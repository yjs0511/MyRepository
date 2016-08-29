package ch06.exam14;

public class Calculator3 {
	//field
	int field1;
	final int field2;
	
	//constructor
	Calculator3(int field2){
		this.field2 = field2;
	}
	
	
	//method
	
	//main method
	public static void main(String[] args){
		Calculator3 ca1 = new Calculator3(5);
		Calculator3 ca2 = new Calculator3(7);
	}
}
