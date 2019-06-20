package com.app;

class A{
	public synchronized void m1() {
			String name = Thread.currentThread().getName();
			m2();
			System.out.println(name+" : m1()");
		}	
	
	public synchronized void m2() {
			String name = Thread.currentThread().getName();
			m1();
			System.out.println(name+" : m2()");
		}
		
}

public class App2 {
	public static void main(String[] args) {
		A a1=new A();
		A a2=new A();

		Runnable task1=()->{
			a1.m1();
		};
		
		Runnable task2=()->{
			a2.m2();
		};
		
		Thread thread1 = new Thread(task1,"T1");
		Thread thread2 = new Thread(task2,"T2");
		
		thread1.start();
		thread2.start();
		
	}

}
