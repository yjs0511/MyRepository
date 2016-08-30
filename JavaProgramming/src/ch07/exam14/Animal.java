package ch07.exam14;

public abstract class Animal {
	public String kind;
	
	public void breath(){
		System.out.println("숨쉰다.");
	}
	
	public abstract void sound();
}
