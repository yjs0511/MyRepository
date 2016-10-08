package sample.nhn.pr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*입력이 6 20 34 8 38 40 인 경우
가장 가까운 거리에 있는 두 점은 (6, 8), (38, 40)이며 합이 최소가 되는 쌍은 (6,8)이다. 따라서 결과는 다음과 같다. 
6 8*/

public class Q1 {
	public static void main(String[] args) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();

		int min = Integer.MAX_VALUE; // 최소 값
		int near = 0; // 가장 가까운 수
		int diff = Integer.MAX_VALUE; // 두 수의 차이

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String input = br.readLine();
			String[] numStrList = input.split(" ");
			for (String numStr : numStrList) {
				numberList.add(Integer.parseInt(numStr));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 다음과 같은 방식으로 numberList와 number 변수를 사용할 수 있음

		for (int i = 0; i < numberList.size(); i++) {
			if (numberList.get(i) < min) {
				min = numberList.get(i);
			}
		}

		for (int i = 0; i < numberList.size(); i++) {
			if (numberList.get(i) != min) {
				int a = Math.abs(numberList.get(i) - min);
				if (diff > a) {
					diff = a;
					near = numberList.get(i);
				}
			}
		}

		System.out.println(min + " " + near + " " + diff);

		/*
		 * for (Integer number : numberList) {
		 * if(Math.abs(numberList.get(i)-numberList.get(j)) < min){ min =
		 * Math.abs(numberList.get(i)-numberList.get(j)); near =
		 * numberList.get(j); }
		 * 
		 * System.out.println("number=" + number); }
		 */

	}
}