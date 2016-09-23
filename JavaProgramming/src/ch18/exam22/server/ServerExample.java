package ch18.exam22.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
	private static ServerSocket serverSocket;
	private static boolean stop;
	private static ExecutorService executorService;
	
	public static void main(String[] args) {
		System.out.println("[서버 시작]");
		try {
			//스레드풀 생성
			executorService = Executors.newFixedThreadPool(50);
			
			// 서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);
			
			//클라이언트의 연결을 수락하는 작업 생성
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					waitAndAccept();
				}
			};
			
			//작업을 스레드풀의 작업큐에 넣기
			executorService.submit(runnable);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("명령어 입력 : ");
			String command = scanner.nextLine();
			if (command.equals("stop")) {
				stop = true; // 작업 스레드 중지(클라이언트의 연결 수락을 중지)
				try {
					serverSocket.close(); // 다 쓴 후에는 연결을 끊어라
					executorService.shutdown();	//스레드풀 해제
				} catch (IOException e) {}
				System.out.println("[서버 종료]");
				System.exit(0);	//서버 프로세스 종료
			}
		}
	}
	
	private static void waitAndAccept(){
		try {
			while(!stop) {
				// 클라이언트의 연결을 수락하고 통신용 socket 생성
				Socket socket = serverSocket.accept(); // 클라이언트의 정보를 가지고 있다.
				
				//통신을 담당하는 객체(Cliet 객체) 생성
				Client client = new Client(socket); 
			}
		} catch (IOException e) {}
	}
	
	static class Client{
		Socket socket;
		
		public Client(Socket socket){
			this.socket = socket;
			receive();
		}
		
		public void receive(){	
			//클라이언트의 데이터를 받고 에코 보내기를 하는 작업 생성
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					try {
						while (true) {	//이게 try 밖에 있으면 예외가 발생해도 다시 반복하게 된다. 
										//따라서 예외발생시 종료 시킬려면 반복문을 try안에 있어야 한다.
							// 클라이언트에서 보낸 데이터를 받기
							InputStream is = socket.getInputStream();
							byte[] receiveValue = new byte[1024];
							int byteNum = is.read(receiveValue);
							if (byteNum != -1) {
								String data = new String(receiveValue, 0, byteNum, "UTF-8");
								System.out.println(socket.getInetAddress().getHostAddress() + "님으로 부터 데이터 받기 성공");

								// 클라이언트로 에코 보내기
								OutputStream os = socket.getOutputStream();
								byte[] sendValues = data.getBytes("UTF-8");
								os.write(sendValues);
								os.flush();
							} else {
								break;
							}
						}
					}catch(Exception e){}
					
					// 클라이언트의 연결을 끊음
					try {
						socket.close();
					} catch (IOException e) {}
				}
			};
			
			//작업을 스레드풀의 작업큐에 넣기
			executorService.submit(runnable);
		}
	}
}

















