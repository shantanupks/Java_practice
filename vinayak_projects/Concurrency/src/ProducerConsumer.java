import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

class NumberFactory {
	private Object lock;
	private Queue<Integer> store = new LinkedList<>();
	private int count;
	private int delay;
	private final int increment = 2;
	
	NumberFactory(int seed, int delay){
		this.lock = new Object();
		this.count = seed;
		this.delay = delay;
	}
	
	private boolean isStoreFull() {
		return store.size() == 10;
	}
	
	private boolean isStoreEmpty() {
		return store.size() == 0;
	}

	public void produce() {
		synchronized(lock) {
			if( isStoreFull() ) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			store.add(count);
			count += increment;
			
			lock.notify();
			
		}	
			try {
				TimeUnit.MILLISECONDS.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public int getItem() {
		synchronized (lock) {
			if( isStoreEmpty()) {
				try {
					lock.wait();
				}  catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int num = this.store.poll();
			lock.notify();
			return num;
		}
	}

}

public class ProducerConsumer {
	
	public static void main(String[] args) throws InterruptedException {
		NumberFactory evenFactory = new NumberFactory( 0, 500);
		NumberFactory oddFactory = new NumberFactory( 1, 600);
		
		Runnable r1 = ()-> { while(!Thread.currentThread().isInterrupted())evenFactory.produce();};
		Runnable r2 = ()-> { while(!Thread.currentThread().isInterrupted())oddFactory.produce();};
		
		List<Integer> numbers = new LinkedList<>();
		
		
		Thread thread1 = new Thread(r1);
		Thread thread2 = new Thread(r2);
		
		thread1.start();
		thread2.start();
		
		Runnable r3 = () -> {
			int num = -1;
			while( num < 101 ) {
				num = evenFactory.getItem();
				numbers.add(num);
				System.out.println(num);
				num = oddFactory.getItem();
				numbers.add(num);
				System.out.println(num);
			}
			thread1.interrupt();
			thread2.interrupt();
		};
		
		Thread thread3 = new Thread(r3);
		thread3.start();
		thread3.join();
		
		numbers.stream().forEach(System.out::println);
		
	}
}
