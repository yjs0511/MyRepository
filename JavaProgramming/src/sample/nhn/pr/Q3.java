package sample.nhn.pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3 {
    public static void main(String[] args) {
        int number = 0;
        int revNum = 0;
        String line = null;
        String str = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            line = br.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        while(true){
        	
        	str = null;
        	
        	for(int i=line.length()-1; i>=0; i--){
        		str += line.charAt(i);
        	}
        	
        	str = str.substring(4);
        
        	revNum = Integer.parseInt(str);
        
        	if(revNum == number){
        		System.out.println(number);
        		break;
        	}else{
        		revNum = revNum + number;	
        		
        		line = String.valueOf(revNum);
        		number = revNum;
        	}
        	
        }

        // write your code here
    }
}