package ch18.exam17.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);

			// 서버의 특정 IP로 접근할 수 있도록 한 것
			/*
			 * serverSocket = new ServerSocket(); SocketAddress sa = new
			 * InetSocketAddress("198.168.0.34", 5001); serverSocket.bind(sa);
			 */

			// 클라이언트의 연결을 수락하고 통신용 Socket을 생성
			for (int i=0; i<10; i++) {
				//클라이언트의 연결을 수락하고 통신용 socket 생성
				System.out.println("[클라이언트의 연결을 기다림.]");
				Socket socket = serverSocket.accept();	// 클라이언트의 정보를 가지고 있다.
				
				//클라이언트의 IP 정보 얻기
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println("[클라이언트("+ clientIP +")의 연결을 수락함.]");
				
				//클라이언트의 연결을 끊음
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			serverSocket.close();	// 다 쓴 후에는 연결을 끊어라
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
