package ch15.exam01;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("java", "jdbc", "database");
		System.out.println(list.size());
		
		for(String str : list){
			System.out.println(str);
		}
		
		/*list.remove(1);
		list.add("JSP");*/
		
	}
}
