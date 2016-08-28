package ch06.exam09;

public class Car {
	//field
	int gas;
	
	//constructor
	
	//method
	void setGas(int gas){
		this.gas = gas;
	}
	
	boolean isLeftGas(){
		if(gas == 0){
			System.out.println("gas가 없습니다.");
			return false;
		}else{
			System.out.println("gas가 있습니다.");
			return true;
		}
	}
	
	void run(){
		while(true){
			if(gas > 0){
				System.out.println("달립니다. (gas 잔량 : "+ gas +")");
				gas--;
			}else{
				System.out.println("멈춥니다. (gas 잔향 : "+ gas + ")");
				return;
			}
		}
	}
}
