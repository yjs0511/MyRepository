package ch11.exam10;

import java.io.IOException;

public class KeyBoardToStringExample {
	public static void main(String[] ar) throws IOException{
		byte[] bytes = new byte[100];	//알파벳 100개 한글 50개 입력 가능
		
		System.out.print("입력 : ");
		int readByteNo = System.in.read(bytes);		// System.in 하면 키보드 /read()는 하나의 키만 읽어라 / 배열을 주면 키 값들을 저장해진다 
		// int로 저장하면 읽은 키의 수를 저장한다는 뜻 (엔터 포함 2byte)
		
		//String str = new String(bytes);  // 엔터 포함해서 이렇게 쓰면 안된다
		String str = new String(bytes, 0, readByteNo-2);
		System.out.println(str);
		
		// String에서 메소드에 대해 잘 말하는 사람은 코딩 많이 해본 사람
		// 말 못하면 코딩 많이 안 해본 사람
	}
}
