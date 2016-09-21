package ch18.exam10;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterExample {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/ch18/exam10/Naver.html");	// 반드시 존재하는 파일을 입력해야 한다
		FileWriter fw = new FileWriter("src/ch18/exam10/Naver2.html");	// 없는 걸 넣어도 알아서 만들어 준다
		
		char[] values = new char[1024];		
		int charNum;
		while((charNum = fr.read(values)) != -1){
			fw.write(values, 0, charNum);
		}
		fw.flush();
		
		fr.close();
		fw.close();
	}
}
