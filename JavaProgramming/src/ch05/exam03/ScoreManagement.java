package ch05.exam03;

import java.util.Scanner; // 표준 API

public class ScannerManagement {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[][] students = null;
		while (true) {
			System.out.println("------------------------------------------------------------------------");
			if (students == null) {
				System.out.println("1. 총 학생수 | 7. 종료");
			} else {
				System.out.println("1. 총 학생수 | 2. 목록 | 3. 입력 | 4. 삭제 | 5. 최고 점수 | 6. 평균 | 7. 종료");
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.print("총 학생수 : ");
				int totalNum = Integer.parseInt(scanner.nextLine());
				students = new String[totalNum][];
			} else if (choice.equals("2")) {
				System.out.println("***************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("***************************************");
				for (String[] student : students) {
					if (student != null) {
						System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
					}
				}
			} else if (choice.equals("3")) {
				System.out.print("학생이름 : ");
				String name = scanner.nextLine();
				System.out.print("점수 : ");
				String score = scanner.nextLine();
				for (int i = 0; i < students.length; i++) {
					if (students[i] == null) {
						String[] student = { String.valueOf(i), name, score };
						students[i] = student;
						break;
					}
				}
			} else if (choice.equals("4")) {
				System.out.print("삭제할 학번 : ");
				int deleteNum = Integer.parseInt(scanner.nextLine());
				students[deleteNum] = null;
				System.out.println(deleteNum + "번 학생 정보가 삭제되었습니다.");
				// scanner.nextLine();
			} else if (choice.equals("5")) {
				int max = 0;
				for (String[] student : students) {
					if (student != null) {
						int score = Integer.parseInt(student[2]);
						if (max < score) {
							max = score;
						}
					}
				}

				for (String[] student : students) {
					if (student != null) {
						int score = Integer.parseInt(student[2]);
						if (max == score) {
							System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
						}
					}
				}

			} else if (choice.equals("6")) {
				int count = 0;
				int sum = 0;
				for(String[] student : students){
					if(student != null){
						count++;
						sum += Integer.parseInt(student[2]);
					}
				}
				System.out.println("평점 : "+ (double) sum / count);

			} else if (choice.equals("7")) {
				break;
			} else {
				System.out.println("1번부터 5번 중에 골라주세요.");
			}
		}
	}
}
