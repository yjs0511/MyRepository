package ch18.exam15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("src/ch18/exam15/data.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Member member = new Member("angel", "천사", "12345", 26);
		oos.writeObject(member);
		
		oos.flush();
		oos.close();
		fos.close();
		
		//---------------------------------------------------------------------------------
		
		FileInputStream fis = new FileInputStream("src/ch18/exam15/data.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Member member2 = (Member) ois.readObject();	//위의 멤버 객체와 이 멤버 객체는 다른 것
		ois.close();
		fis.close();
		
		System.out.println(member2.getMid());
		System.out.println(member2.getMname());
		System.out.println(member2.getMage());
		System.out.println(member2.getMpassword());
		System.out.println(member2.getNation());
	}
}
