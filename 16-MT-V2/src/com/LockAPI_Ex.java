package com;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAPI_Ex {
	private static int[] buffer;
	private static int count = 0;
	private static Lock lock = new ReentrantLock();
	private static Condition notFull = lock.newCondition();
	private static Condition notEmpty = lock.newCondition();

	static boolean isEmpty() {
		return count == 0;
	}

	static boolean isFull() {
		return count == buffer.length;
	}

	static class Producer {
		void produce() {
			lock.lock();
			if (isFull()) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
			buffer[count++] = 1;
			notEmpty.signal();
		}
	}

	static class Consumer {
		void consume() {
			
			try {
			
			lock.lock();
			if(isEmpty()) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			buffer[--count]=0;
			notFull.signal();
			}finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		buffer = new int[5];
		Producer producer = new Producer();
		Consumer consumer = new Consumer();

		Runnable produceTask = () -> {
			for (int i = 0; i < 100; i++) {
				producer.produce();
			}
		};
		Runnable consumeTask = () -> {
			for (int i = 0; i < 95; i++) {
				consumer.consume();
			}
			System.out.println("Done consuming");
		};

		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);

		consumerThread.start();
		producerThread.start();

		consumerThread.join();
		producerThread.join();

		System.out.println("Data produced :" + count);

	}

}
