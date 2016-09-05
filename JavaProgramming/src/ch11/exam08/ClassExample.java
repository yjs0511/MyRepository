package ch11.exam08;

public class ClassExample {
	public static void main(String[] args) throws ClassNotFoundException{
		//Class classCar = Car.class;	// 1)
		//Class classCar = Class.forName("ch11.exam08.Car");	// 2)
		Car car = new Car();		// 3)
		Class classCar = car.getClass();
		
		System.out.println(classCar.getName());
		System.out.println(classCar.getSimpleName());
		System.out.println(classCar.getPackage().getName());
	}
}
