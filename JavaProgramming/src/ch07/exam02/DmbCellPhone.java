package ch07.exam02;

public class DmbCellPhone extends CellPhone {
	//field
	int channel;
	
	//constructor
	public DmbCellPhone(String model, String color, int channel){
		super(model, color);	// 자식 생성자에서 수퍼() 이거 생성 안하면 컴파일러가 알아서 넣어줌
		super.model = model;
		super.color = color;
		this.channel = channel;
	}
	
	//method
	void turnOnDmb(){
		System.out.println("채널 "+channel+"번 DMB 방송 수신을 시작합니다.");
	}
	
	void changeChannelDmb(int channel){
		this.channel = channel;
		System.out.println("채널 "+channel+"번으로 바꿉니다.");
	}
	
	void turnOffDmb(){
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
