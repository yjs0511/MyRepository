package ch15.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static void main(String[] ar){
		Set<Member> set = new HashSet<>();
		
		Member m1 = new Member("홍길동", 25);
		Member m2 = new Member("홍길동", 25);
		
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));	// equals는 기본적으로 object의 것을 사용 '=='와 같은 효과 메모리 주소를 비교 
		System.out.println(m1.hashCode() == m2.hashCode());		// 메모리 주소 기반이라 다르다
		
		set.add(m1);
		set.add(m2);
		System.out.println(set.size());
		
		
	}
}
