package ch15.exam01;

import java.util.LinkedList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args){
		//List 계열의 컬렉션 생성
		List<String> list = new LinkedList<>();	// List 인터페이스를 가지고 ArrayList()를 사용하겠다
		
		//객체 저장
		list.add("JAVA");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("ibatis");
		
		//저장된 객체수 얻기
		int size = list.size();
		System.out.println("총 개체 수: "+size);
		
		
		//객체 찾기
		String skill = list.get(2);
		System.out.println("2: "+skill);
		System.out.println();
		
		for(int i=0; i<size; i++){
			String str = list.get(i);
			System.out.println(i+": "+str);
		}
		System.out.println();
		
		for(String str : list){		//향상된 for문 사용하려면 Iterable<E> 이 인터페이스를 구현해야 한다.
			System.out.println(str);
		}
		
		//객체 삭제
		list.remove(2);
		list.remove(2);
		System.out.println();
		System.out.println(list.get(2));
		list.remove(new String("ibatis"));		//내부적으로 equals()를 사용하기 때문에 같은 내용도 같이 사라진다.
		System.out.println(list.size());
	}
}
