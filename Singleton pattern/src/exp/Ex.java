package exp;

import sun.misc.Signal;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton obj = Singleton.getInstance();
		System.out.println();
		Singleton obj2 = Singleton.getInstance();
		System.out.println(obj2.s);

	}

}
