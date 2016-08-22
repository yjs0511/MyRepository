package homework;

import java.util.Scanner;

public class Board {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] board = new String[100][];

		while (true) {
			System.out.println("------------------------------------------------------------------------");
			if (board == null) {
				System.out.println("2. 글쓰기 | 6. 종료");
			} else {
				System.out.println("1. 목록 | 2. 글쓰기 | 3. 상세보기 | 4. 수정하기 | 5. 삭제하기 | 6. 종료");
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.println("*********************************************************");
				System.out.println("|게시물 번호\t|제목\t\t|글쓴이\t\t|조회수|");
				System.out.println("*********************************************************");
				for (String[] article : board) {
					if (article != null) {
						System.out
								.println(article[0] + "\t\t" + article[1] + "\t\t" + article[2] + "\t\t" + article[4]);
					}
				}
			} else if (choice.equals("2")) {
				System.out.print("제목 : ");
				String subject = scanner.nextLine();
				System.out.print("글쓴이 : ");
				String name = scanner.nextLine();
				System.out.print("내용 : ");
				String text = scanner.nextLine();
				for (int i = 0; i < board.length; i++) {
					if (board[i] == null) {
						String[] article = { String.valueOf(i), subject, name, text, "0" };
						board[i] = article;
						break;
					}
				}
			} else if (choice.equals("3")) {
				System.out.print("게시물 번호 : ");
				int artNum = Integer.parseInt(scanner.nextLine());
				int count = Integer.parseInt(board[artNum][4]);
				count++;
				board[artNum][4] = String.valueOf(count);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("제목 : " + board[artNum][1] + "\t\t글쓴이 : " + board[artNum][2] + "\t\t 조회수 : "
						+ board[artNum][4]);
				System.out.println("");
				System.out.println(board[artNum][3]);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
			} else if (choice.equals("4")) {
				System.out.print("수정할 게시물 번호 : ");
				int artNum = Integer.parseInt(scanner.nextLine());
				
				if (board[artNum] != null) {
					System.out.print("제목 : ");
					String subject = scanner.nextLine();
					System.out.print("글쓴이 : ");
					String name = scanner.nextLine();
					System.out.print("내용 : ");
					String text = scanner.nextLine();
				
					board[artNum][1] = subject;
					board[artNum][2] = name;
					board[artNum][3] = text;
				}
			} else if (choice.equals("5")) {
				System.out.print("삭제할 게시물 번호 : ");
				int deleteNum = Integer.parseInt(scanner.nextLine());
				board[deleteNum] = null;
				System.out.println(deleteNum + "번 게시물이 삭제되었습니다.");
			} else if (choice.equals("6")) {
				break;
			}
		}

	}

}
