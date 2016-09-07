package ch12.exam07;

import java.util.Calendar;

public class EnumExample {

	public static void main(String[] args) {
		Week week = Week.TUESDAY;
		
		Calendar now = Calendar.getInstance();
		switch(now.get(Calendar.DAY_OF_WEEK)){
		case 1:	week = week.SUNDAY; break;
		case 2:	week = week.MONDAY; break;	
		case 3:	week = week.TUESDAY; break;
		case 4:	week = week.WEDNEDAY; break;
		case 5:	week = week.THURSDAY; break;
		case 6:	week = week.FRIDAY; break;
		default : week = week.SATURDAY; 
		
		}
		System.out.println(week);
	}

}
