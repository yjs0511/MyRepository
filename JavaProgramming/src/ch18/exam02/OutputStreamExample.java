package ch18.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("src/ch18/exam02/data1.txt");		// 상대 경로
		String data = "abcdefghij";
		byte[] values = data.getBytes();
		for(int i=0; i<values.length; i++){
			os.write(values[i]);
		}
		os.flush();
		os.close();
		
		
		os = new FileOutputStream("src/ch18/exam02/data2.txt");		// 상대 경로
		data = "abcdefghij";
		values = data.getBytes();
		os.write(values);
		os.flush();
		os.close();
	}
}
