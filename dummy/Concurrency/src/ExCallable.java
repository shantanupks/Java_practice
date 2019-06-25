import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Callable<String> call = ()-> "Result is compl";
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> future = executorService.submit(call);
		
		try {
			String res = future.get();
			System.out.println(res);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
