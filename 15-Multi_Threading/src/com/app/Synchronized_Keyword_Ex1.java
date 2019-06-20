package com.app;

import java.util.concurrent.TimeUnit;

class AB {
	public static synchronized void m1() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " : A::m1() start");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " : A::m1() end");
	}

	public static synchronized void m2() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " : A::m2() start");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " : A::m2() end");
	}
}

public class Synchronized_Keyword_Ex1 {

	public static void main(String[] args) {

		Runnable task1 = () -> {
			AB.m1();
		};
		Runnable task2 = () -> {
			AB.m2();
		};

		Thread thread1 = new Thread(task1, "T1");
		Thread thread2 = new Thread(task1, "T2");
		Thread thread3 = new Thread(task2, "T3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

}