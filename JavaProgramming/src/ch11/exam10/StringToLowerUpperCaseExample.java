package ch11.exam10;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		String oldStr = "자바는 객체지향언어입니다. 자바는 풍부한 API를 지원합니다.";	// 이 문자열이 바뀌거나 없어지는게 아니다.
		String newStr = oldStr.replace("자바", "java");	// 새로운 문자열을 참조하는 객체를 만들어낸다.
		System.out.println(oldStr);
		System.out.println(newStr);	
		System.out.println(oldStr == newStr);	// 둘은 다른 객체다.

	}

}
