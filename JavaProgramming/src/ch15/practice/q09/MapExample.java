package ch15.practice.q09;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapExample {
	public static void main(String[] args){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		map.put("holololo", 100);
		
		String name = null;	// 최고 점수 받은 아이디 저장
		int maxScore = 0;	// 최고 점수 저장
		int totalScore = 0;	// 점수 합계 저장
		
		//작성 위치
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for(Entry<String, Integer> entry : entrySet){
			String key = entry.getKey();
			int value = entry.getValue();
			if(value > maxScore){
				maxScore = value;
				name = key;
			}
			totalScore += value;
		}
		System.out.println("점수 합계 : "+ totalScore);
		System.out.println("최고점수 : " + maxScore);
		System.out.println("최고 점수를 받은 아이디 : "+name);
	}
}
