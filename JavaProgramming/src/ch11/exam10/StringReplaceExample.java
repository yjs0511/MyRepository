package ch11.exam10;

public class StringReplaceExample {

	public static void main(String[] args) {
		String oldStr = "Java Programming.";	// 
		String newStr = oldStr.toLowerCase();	// 대문자를 소문자로 바꿔라
												// 원래 문자열이 바뀌는게 아니라 새로운 문자열이 만들어진다.
		System.out.println(oldStr);
		System.out.println(newStr);	
		System.out.println(oldStr == newStr);	// 둘은 다른 객체다.
		
		System.out.println(oldStr.equals("JAVA programming."));	// 둘은 다른 거다!
		System.out.println(oldStr.toLowerCase().equals("JAVA programming.".toLowerCase()));
		System.out.println(oldStr.toUpperCase().equals("JAVA programming.".toUpperCase()));
		
		String targetStr = "            Java Programming.           ";
		System.out.println(oldStr == targetStr);
		System.out.println(oldStr.equals(targetStr));
		System.out.println(oldStr.equals(targetStr.trim()));
	}
}
