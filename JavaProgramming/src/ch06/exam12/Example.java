package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		//Instance Member 사용
		InstanceMember im = new InstanceMember();
		im.field = "자바";
		im.method();
		
		//Static Member 사용
		System.out.println(StaticMember.field);
		StaticMember.method();
	}

}
