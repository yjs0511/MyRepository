package ch12.exam11;

public class AutuSavethread extends Thread {
	public void save(){
		System.out.println("작업 내용 저장");
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {	}
			save();
		}
	}
}
