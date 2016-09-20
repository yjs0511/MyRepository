package ch15.practice.q08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args){
		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));	// 학번이 같이지므로 저장 되지 않음
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()){
			Student student = iterator.next();
			System.out.println(student.studentNum + " : " + student.name);
		}
	}
}
