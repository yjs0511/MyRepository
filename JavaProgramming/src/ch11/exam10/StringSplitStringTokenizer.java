package ch11.exam10;

import java.util.StringTokenizer;

public class StringSplitStringTokenizer {

	public static void main(String[] args) {
		String data = "홍길동,이수홍,박연수,감자바,최명호";	// ,를 구분자로 한 단어들 각각을 Token이라고 한다.
		
		String[] dataArray = data.split(",");
		System.out.println(dataArray.length);
		for(String name : dataArray){
			System.out.println(name);
		}
		
		StringTokenizer st = new StringTokenizer(data, ",");
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()){
			String name = st.nextToken();
			System.out.println(name);
		}
		
		data = "홍길동&이수홍,박연수-감자바&최명호";	// ,를 구분자로 한 단어들 각각을 Token이라고 한다.
		
		dataArray = data.split("&|,|-");
		System.out.println(dataArray.length);
		for(String name : dataArray){
			System.out.println(name);
		}
		
	}
}
