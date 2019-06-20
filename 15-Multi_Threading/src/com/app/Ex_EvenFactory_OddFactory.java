package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex_EvenFactory_OddFactory {
	static List<Integer> list = new ArrayList<Integer>();

	private static Object lock = new Object();
	private static int countEven = 0;
	private static int countOdd = 1;
	static boolean odd = false;

	static class EvenFactory {

		void produceEven() {
			synchronized (lock) {
				while (countEven < 100) {
					while (odd==true)
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(countEven);
					list.add(countEven);
					countEven = countEven + 2;

					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					odd = true;
					lock.notify();
				}
			}

		}
	}

	static class OddFactory {
		void produceOdd() {
			synchronized (lock) {
				while (countOdd < 100) {
					while (!odd)
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					System.out.println(countOdd);
					list.add(countOdd);
					countOdd = countOdd + 2;
					try {
						TimeUnit.MILLISECONDS.sleep(550);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
					odd = false;
					lock.notify();

				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		EvenFactory even = new EvenFactory();
		OddFactory odd = new OddFactory();

		Runnable evenTask = () -> {
			even.produceEven();

		};

		Runnable oddTask = () -> {
			odd.produceOdd();
		};

		Thread oddThread = new Thread(oddTask);
		Thread evenThread = new Thread(evenTask);

		evenThread.start();
		oddThread.start();
		//evenThread.join();
		//oddThread.join();

		list.forEach(System.out::println);
	}

}
