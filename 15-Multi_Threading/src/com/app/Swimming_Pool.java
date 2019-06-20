package com.app;

import java.util.concurrent.TimeUnit;

class Pool {
	
	private Object lock = new Object();
	private Object lock2 = new Object();
	
	boolean boy = false;

	public void swim() {
		String name = Thread.currentThread().getName();
		
		synchronized (lock) {
			if(boy==true)
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			boy = true;
			System.out.println(name + " -- swimming started..");
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " -- swimming finished..");
			boy = false;
			lock.notify();
		}
	}

}

public class Swimming_Pool {

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
