import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ExeCompletableFuture {

	public static void main(String[] args) {
		CompletableFuture<String> future = new CompletableFuture();
		
		future.whenComplete( (result, throwable)->{
			if( throwable != null ) {
				Exception exp = (Exception) throwable;
				exp.printStackTrace();
			}
			
			System.out.println(result);
		});
		
		
		future.whenComplete( (res, throwable)-> {
			if( throwable != null ) {
				Exception exp = (Exception) throwable;
				exp.printStackTrace();
			}
			
			System.out.println(" I am another thread");
		});
		
		Runnable work1 = ()-> {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int noOfDependent = future.getNumberOfDependents();
			System.out.println("Number of dependent "+ noOfDependent);
			future.complete("I am back");
		};
		
		new Thread(work1).start();
	}
}
