package ch18.exam14;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamExample {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("src/ch18/exam14/data.txt");
		PrintStream ps = new PrintStream(fos);	// 바이트 기반이므로 사용 가능
		
		ps.println(10);
		ps.println(true);
		ps.println(5.3);
		ps.println("JAVA");
		ps.flush();
		
		ps.close();
		fos.close();
		
		FileReader fr = new FileReader("src/ch18/exam14/data.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int v1 = Integer.parseInt(br.readLine());
		boolean v2 = Boolean.parseBoolean(br.readLine());
		double v3 = Double.parseDouble(br.readLine());
		String v4 = br.readLine();
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		
		br.close();
		fr.close();
		
	}
}
