package exp;

public class Singleton {
	public static int COUNT = 0;
	private static Singleton instance = null;
	public String s;
	
	private Singleton() {
		this.s = "ssssssss";
		System.out.println(s);
	}

	
	public static Singleton getInstance(){
		COUNT++;
		if(COUNT==1) {
			instance = new Singleton();
			System.out.println("1 instance created");
		}
		else
		{
			System.out.println("2nd instance not allowed");
		}
		return instance;
		}
	

}
