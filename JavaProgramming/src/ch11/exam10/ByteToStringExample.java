package ch11.exam10;

public class ByteToStringExample {

	public static void main(String[] args) throws Exception {
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};	//byte 타입의 배열		ASCII 코드
		String str1 = new String(bytes);	//String 타입의 str1 변수	bytes 변수 값을 참조하는 변수
		System.out.println(str1);	// System 클래스의 정적필드 out (PrintStream 타입)에 접근하여 
		
		String str2 = new String(bytes, 6, 4);	// String 타입의 변수 str2로 String 객체를 참조하라
		System.out.println(str2);
		
		//--------------------------------------------------------------------------------------------------------
		String str3 = "홍길동";
		byte[] strBytes = str3.getBytes();
		String str4 = new String(strBytes);		// 하나의 글자를 2바이트로 읽는다.
		System.out.println(str4);
		
		String str5 = "aa홍길동";		// 3바이트의 문자로
		byte[] strBytes5 = str5.getBytes("UTF-8");	//인코딩		EUC-KR 은 아스키코드 + 유니코드(한국어) 알파벳1바이트 한글 2바이트
		
		String str6 = new String(strBytes5, "UTF-8");	// 디코딩		UTF-8은 아스키코드 + 유니코드(각 나라 언어별로 바이트 수가 다르다)
		System.out.println(str6);	// 인코딩 할때 타입과 디코딩 할 때 타입이 같아야 한다.
		
		String str7 = new String(strBytes5, 2, 9, "UTF-8");		// 	UTF-8은 알파벳 1바이트 한글 3바이트		길이가 아니라 바이트 개수로 접근한다
		System.out.println(str7);
		
		// 인코딩 할 때와 디코딩 할 때 케릭터 셋이 같아야한다.
		// 네크워크에서 클라이언트와 서버 간의 데이터 교환할 때 byte로 보내므로 역시 케릭터 셋이 같아야 한다.
	}

}
