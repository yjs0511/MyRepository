package ch13.exam06;

public class CompareMethodExample {
	public static void main(String[] args) {
		Pair<String, String> p1 = new Pair<String, String>("name", "홍길동");
		Pair<String, String> p2 = new Pair<String, String>("name", "홍길동");
		boolean result = Util.compare(p1, p2);
		System.out.println(result);
	}
}
