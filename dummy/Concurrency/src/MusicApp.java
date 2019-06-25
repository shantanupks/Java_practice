import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 
 * Variable with volatile will make visibiltiy clear to other thread.
 * Without volatile--
 * 			If there are multiple threads workign on single variable. 
 * 			Changes made to variable will be made in cache.
 * 			Which other thread may not able to read.
 * With volatile
 * 			Any changes made to variable will be reflected in ram
 * 			Other thread will now have clear visibility of variable. 
 * @author Vinayak
 *
 */
public class MusicApp {

	private static volatile boolean canContinue = true;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable play = ()->{
			while( true) {
				if( canContinue)
				System.out.println("Playing song");
			}
		};
		
		Runnable stop = ()->{
			for(int i = 0 ; i < 5; i++) {
				canContinue = false;
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				canContinue = true;
			}
			canContinue = false;
		};
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		executorService.submit(play);
		executorService.submit(stop);
		
		
	}

}
