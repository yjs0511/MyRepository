package ch11.exam09;

public class NewInstanceExample {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("ch11.exam09." + args[0]);
		
		Object obj = c.newInstance();
		Action action = (Action) obj; 
		
		action.execute();
	}

}
