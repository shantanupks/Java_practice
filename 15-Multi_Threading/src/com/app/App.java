package com.app;

public class App {
	public static void main(String[] args) {
		
		System.out.println("main: ......");

		
		Runnable task = (()->{
			String name = Thread.currentThread().getName();
			System.out.println(name+ ".....");
			doComputation();
		});
		
		Runnable task2 = (()->{
			String name = Thread.currentThread().getName();
			System.out.println(name+ ".....");
			doIO();
		});
		
		
		Thread thread1 = new Thread(task);
		thread1.start();
		
		Thread thread2 = new Thread(task2);
		thread2.start();
		
		System.out.println("main: ......");
				
				
	}
	
	private static void doIO() {
		System.out.println("IO......");
		System.out.println("enter name :");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("Name :"+s);
	}
	

	private static void doComputation() {
		// TODO Auto-generated method stub
		System.out.println("computation....");

	}

}
