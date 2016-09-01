package ch09.exam11;

public class ButtonExample {

	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick() {
				System.out.println("음악 재생");
			}
		});
		
		Button btnCancel = new Button();
		btnCancel.setOnClickListener(new Button.OnClickListener(){
			public void onClick() {
				System.out.println("음악 끝");
			}
		});
		
		btnOk.click();
		btnCancel.click();
	}
}
