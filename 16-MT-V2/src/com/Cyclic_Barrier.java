package com;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cyclic_Barrier {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		CyclicBarrier barrier = new CyclicBarrier(10);
		Runnable task=()->{
			int count=0;
			for(int i=0;i<10;i++) {
				count++;
				System.out.println(Thread.currentThread().getName() + " : step-count - " + i);

			}
				
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " : total-count - " + count);
				
			
		};
		
		for(int i=0;i<10;i++) {
			executorService.submit(task);
		}
	}

}
