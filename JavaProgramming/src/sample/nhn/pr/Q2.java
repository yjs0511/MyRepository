package sample.nhn.pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
    public static void main(String[] args) {
        String[] words = null;
      
        int ooOa = 0; 	//oo 혹은 oa가 포함된 글자의 개수
        int spl = 0;	//spl이 포함된 글자의 수	
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            words = line.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
               
        // 다음과 같은 방식으로 words와 word 변수를 사용할 수 있음
        
        for (String word : words) {
        	if(word.indexOf("oo") != -1 || word.indexOf("oa") != -1){
        		ooOa++;
        	}else if(word.indexOf("spl") != -1){
        		spl++;
        	}
        }
        
        System.out.println(ooOa);
        System.out.println(spl);
        
    }
}