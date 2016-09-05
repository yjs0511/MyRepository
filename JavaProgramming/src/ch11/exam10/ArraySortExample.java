package ch11.exam10;

import java.util.Arrays;

public class ArraySortExample {

	public static void main(String[] args) {
		int[] scores = {99, 97, 98};
		
		Arrays.sort(scores);
		System.out.println(Arrays.toString(scores));
		
		Members[] members = {new Members("수퍼맨", 99),new Members("앤트맨", 97),new Members("배트맨", 98)};
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
	}
}

class Members implements Comparable{
	String name;
	int score;
	Members(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name +" : " + score;
	}
	
	@Override
	public int compareTo(Object o) {
		Members target = (Members) o;
		System.out.println("compareTo");
		return score - target.score;
	}
}
