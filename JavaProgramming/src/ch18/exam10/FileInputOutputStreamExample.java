package ch18.exam10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputStreamExample {

	public static void main(String[] args) throws IOException {
		InputStream fis = new FileInputStream("src/ch18/exam10/Desert.jpg");	// 반드시 존재하는 파일을 입력해야 한다
		OutputStream fos = new FileOutputStream("src/ch18/exam10/Desert2.jpg");	// 없는 걸 넣어도 알아서 만들어 준다
		
		byte[] values = new byte[1024];		
		int byteNum;
		while((byteNum = fis.read(values)) != -1){
			fos.write(values, 0, byteNum);
		}
		fos.flush();
		
		fis.close();
		fos.close();
	}

}
