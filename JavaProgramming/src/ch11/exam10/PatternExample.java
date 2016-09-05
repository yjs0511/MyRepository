package ch11.exam10;

import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {
		String tel1 = "010-123-1234";
		String tel2 = "013-123-1234";
		String tel3 = "010-1234-1234";
		String tel4 = "010-123-123";
		
		String regExp = "(010|011)-\\d{3,4}-\\d{4}";
		
		System.out.println(Pattern.matches(regExp, tel1));
		System.out.println(Pattern.matches(regExp, tel2));
		System.out.println(Pattern.matches(regExp, tel3));
		System.out.println(Pattern.matches(regExp, tel4));
		
		String email = "h@naver.com";
		String emai2 = "hnaver.com";
		String emai3 = "h@naver";
		
		String regExp2 = "\\w+@\\w+\\.\\w+";
		
		/*System.out.println(Pattern.matches(regExp, email1));
		System.out.println(Pattern.matches(regExp, email2));
		System.out.println(Pattern.matches(regExp, email3));*/
		
	
	}

}
