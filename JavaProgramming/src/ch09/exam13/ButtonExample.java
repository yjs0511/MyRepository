package ch09.exam13;

public class ButtonExample {

	public static void main(String[] args) {
		Button btnOk = new Button();
		int value = 10;
		
		btnOk.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick() {
				//value = 5;  // 로컬 클래스 내에서 사용되기 때문에 final 특성을 가진다.
				System.out.println("음악 재생");
			}
		});
		
		btnOk.click();
	}
}
