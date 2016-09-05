package ch11.exam10;

public class StringBuilderExample {

	public static void main(String[] args) {
		String data = "a";
		data += "b";
		data += "c";
		
			
		System.out.println(data);
		
		//String 객체안의 문자열은 못 건드린다 
		//StringBuilder 안의 문자열은 조작 가능
		StringBuilder sb = new StringBuilder();
		sb.append("a");
		sb.append("b");
		sb.append("c");
		System.out.println(sb);
		
		String data2 = "abc";
		StringBuilder sb2  = new StringBuilder(data2);
		sb2.insert(1, "0");
		data2 = sb2.toString();
		System.out.println(data2);
		
	}

}
