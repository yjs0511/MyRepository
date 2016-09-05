package ch11.exam10;

public class StringCharAtExample {

	public static void main(String[] args) {
		String ssn = "010624-3230123";
		char gender = ssn.charAt(7);
		System.out.println(gender);

		switch (gender) {
		case '1':
			break;
		case '2':
			break;
		case '3':
			System.out.println("남자");
			break;
		case '4':
			System.out.println("여자");
			break;

		}
	}

}
