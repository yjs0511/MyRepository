package ch15.exam04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = null;
		Locale currentLocal = Locale.getDefault();
		if(currentLocal == Locale.KOREA){
			path = PropertiesExample.class.getResource("ko.properties").getPath();	//클래스를 기준으로 파일을 찾는데 그 파일 이름이 ko.properties 
			System.out.println(path);
		}else if(currentLocal == Locale.US){
			path = PropertiesExample.class.getResource("en.properties").getPath();
			System.out.println(path);
		}
		
		Properties properties = new Properties();
		properties.load(new FileReader(path));
		
		String appTitle = properties.getProperty("apptitle");
		String btnLogin = properties.getProperty("btnLogin");
		String btnJoin = properties.getProperty("btnJoin");
		String btnCancel = properties.getProperty("btnCancel");
		
		System.out.println(appTitle);
		System.out.println(btnJoin);
		System.out.println(btnLogin);
		System.out.println(btnCancel);
		
		
	}
}
