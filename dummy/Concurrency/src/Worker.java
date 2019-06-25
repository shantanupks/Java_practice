import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


class Person {
	private String name;
	private String title;
	
	Person(String name, String title){
		this.name = name;
		this.title = title;
	}
	
	public synchronized String getName(Person p2) {
//		synchronized(p2) {
			return name + p2.getTitle();
//		}
	}
	public synchronized String getTitle() {
		return title;
	}
}

class Demo{
	public static void method1() {
		synchronized(Demo.class) {
			method2();
		}
	}
	public synchronized void method3() {
		System.out.println("Inside method 3");
		try {
			this.notify();
			this.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got lock again");
	}
	public static void method2() {
		synchronized(Demo.class) {
			System.out.println("Method2 is executing");
		}
	}
}
public class Worker {

	
	
	public static void main(String []args) throws InterruptedException {
		
		Person p1 = new Person("Mary", "Er");
		Person p2 = new Person("John", "Dr");
		
		Runnable work1 = ()-> {
			String result = p1.getName(p2);
			System.out.println(result);
		};
		Runnable work2 = ()-> {
			String result = p2.getName(p1);
			System.out.println(result);
		};
//		
		
		Demo demo = new Demo();
		
//		Runnable work1 = ()-> {
//			demo.method3();
//		};
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		executorService.execute(work1);
		executorService.execute(work2);
		
//		Thread thread = new Thread(()-> Demo.method1());
//		thread.start();
		
		executorService.shutdown();
	}
}
