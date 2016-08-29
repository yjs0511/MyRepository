package ch06.exam17;

public class Member {
	private String mid;
	private String mname;
	private String mpassword;
	private int mage;
	private boolean adult;
	private double mheight;
	
	public Member(String mid){
		this.mid = mid;
	}
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setHeight(double mheight) {
		if(mheight < 0){
			mheight = 0;
		}
		this.mheight = mheight;
	}
	
}
