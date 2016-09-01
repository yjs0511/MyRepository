package ch09.exam13;

public class Button {
	public static interface OnClickListener{
		void onClick();
	}
	
	private OnClickListener onClickListener;
	
	public void setOnClickListener(OnClickListener onClickListener) {	// OnClickListener를 구현한 구현 객체
		this.onClickListener = onClickListener;
	}
	
	public void click(){
		if(onClickListener != null){
			onClickListener.onClick();
		}
	}
	
}
