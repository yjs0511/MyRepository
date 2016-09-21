package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedOutputStreamExample {

	public static void main(String[] args) throws IOException {
		long start = 0;
		long end = 0;
		
		InputStream fis = new FileInputStream("src/ch18/exam12/Penguins.jpg");	// 반드시 존재하는 파일을 입력해야 한다
		OutputStream fos = new FileOutputStream("src/ch18/exam12/Penguins2.jpg");	// 없는 걸 넣어도 알아서 만들어 준다
		
		int value;
		
		start = System.currentTimeMillis();
		while((value = fis.read()) != -1){
			fos.write(value);
		}
		fos.flush();
		
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		fis.close();
		fos.close();
		
		//-----------------------------------------------------------------------
		
		InputStream fis2 = new FileInputStream("src/ch18/exam12/Penguins.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);	
		
		OutputStream fos2 = new FileOutputStream("src/ch18/exam12/Penguins2.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos2);	
		
		start = System.currentTimeMillis();
		while((value = bis.read()) != -1){
			bos.write(value);
		}
		bos.flush();
		
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		bis.close();
		bos.close();
		fis2.close();
		fos2.close();
	}

}
