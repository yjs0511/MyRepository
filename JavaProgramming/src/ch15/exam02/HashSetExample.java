package ch15.exam02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		//Set 계열 컬렉션 생성
		Set<String> set = new HashSet<>();
		
		//객체 저장
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("JDBC");
		//set.add("Java");	//중복 count 안함
		set.add("iBatis");
		System.out.println(set.size());
		System.out.println();
		
		//객체를 일괄 처리
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			if(str.equals("JDBC")){
				iterator.remove();
			}
			System.out.println(str);
		}
		
		System.out.println();
		for(String str : set){
			System.out.println(str);
		}
	}
}
