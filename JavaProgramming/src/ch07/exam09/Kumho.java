package ch07.exam09;

public class Kumho extends Tire {
	//field
	
	//constructor
	public Kumho(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//method
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation){
			System.out.println(location + " KumhoTire 수명 : "+(maxRotation - accumulatedRotation)+"회");
			return true;
		}else{
			System.out.println("*** "+location+" KumhoTire 펑크 ***");
			return false;
		}
	}
}
