package ch18.exam16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
	public static void main(String[] ar) throws UnknownHostException{
		InetAddress myIA = InetAddress.getLocalHost();
		String myIP = myIA.getHostAddress();
		System.out.println("내 컴퓨터 IP 주소 : "+myIP);
		
		InetAddress[] naverIAs = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ia : naverIAs){
			System.out.println("네이버 IP주소 : "+ia.getHostAddress());
		}
	}
}
