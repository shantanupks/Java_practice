package com.app;

public class Yeild_Ex {
	public static void main(String[] args) {
		
		Runnable bigtask = ()->{
			String name = Thread.currentThread().getName();
			for(int i=0;i<100;i++) {
				System.out.println(name + " -> " + i);
				if (i == 10)
					Thread.yield();
			}
		};
		
		Thread thread1 = new Thread(bigtask, "A");
		Thread thread2 = new Thread(bigtask, "B");

		thread1.start();
		thread2.start();
		
	}

}
