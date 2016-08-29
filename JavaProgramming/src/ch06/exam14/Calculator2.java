package ch06.exam14;

public class Calculator2 {
	//field
	int field1;
	final int field2;
	
	static int field3;
	static final int FIELD4 = 3;
	
	//constructor
	Calculator2(int field2){
		this.field2 = 5;
	}
	
	static{
		//field4 = 5;		// 위에서 초기화 해서 안된다.
	}
	
	//method
}
