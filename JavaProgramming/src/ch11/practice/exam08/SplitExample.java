package ch11.practice.exam08;

import java.util.StringTokenizer;

public class SplitExample {
	public static void main(String[] args) {
		String str = "���̵�,�̸�,�н�����";
		
		//���1(splict() �޼ҵ� �̿�)
		String[] tokens = str.split(",");
		for(int i=0; i<tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		
		System.out.println();
		
		//���2(StringTokenizer �̿�)
		StringTokenizer st = new StringTokenizer(str, ",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		
	}
}
