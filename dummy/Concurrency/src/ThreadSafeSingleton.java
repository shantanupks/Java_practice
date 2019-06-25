

/**
 * Perfect way to implement singleton is to use enum.
 * Class based singleton pattern is not perfect. If there are multiple classloadders loading same class.
 * There are chances of multiple instance.
 * @author Vinayak
 *
 */
class Singleton{
	private static Singleton singleton;
	
	// Single check
	/**
	 * Parraller reads are not allowed
	 * @return
	 */
//	public static synchronized Singleton getInstance() {
//		if( singleton == null )
//			singleton = new Singleton();
//		
//		return singleton;
//	}
	
	
	// Double Check
	/**
	 * Parallel reads are allowed
	 * Other thread is volatility of instance.
	 * Mark instance as volatile
	 * @return
	 */
	public static synchronized Singleton getInstance() {
		if( singleton != null )
			return singleton;
		
		synchronized(Singleton.class) {
			if( singleton == null )
				singleton = new Singleton();
		}
		
		return singleton;
	}
	
	public boolean isSame(Singleton other) {
		return singleton == other;
	}
}


public class ThreadSafeSingleton {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
