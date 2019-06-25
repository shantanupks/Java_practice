import java.util.concurrent.TimeUnit;

/**
 * Object.wait() - current executing thread will stop its execution. 
 * 		And wait till OTHER thread have called notify on same lock.
 * 
 * Object.notify() - current exe thread will notify on lock. So any thread waiting for lock
 * 		will wake up.
 * 
 * 
 * In this example - boy thread will acquired lock. After completion of swimming it will notify
 * 	other thread waiting for lock. and also goes to wait state. to allow to get alternate
 * 	chances.
 * 
 * @author nexwave
 *
 */
class Pool {

	private Object lock = new Object();

	public void swim() {
		String name = Thread.currentThread().getName();
		synchronized (lock) {
			System.out.println(name + " -- swimming started..");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " -- swimming finished..");
			lock.notify();
			try {
				lock.wait(TimeUnit.SECONDS.toSeconds(1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

public class WaitNotify {

	public static void main(String[] args) {

		Pool pool = new Pool();

		Runnable swimTask = () -> {
			for (int i = 0; i < 5; i++) {
				pool.swim();
			}
		};

		Thread thread1 = new Thread(swimTask, "boy");
		Thread thread2 = new Thread(swimTask, "girl");

		thread1.start();
		thread2.start();

	}

}