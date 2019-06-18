package com;

import java.util.function.Consumer;

public class Closure_Ex {
	public static void main(String[] args) {
		String sub;
		Consumer<String> consumer = teach("sds");
		consumer.accept("student");
	}

	private static Consumer<String> teach(String sub) {
		// TODO Auto-generated method stub
		System.out.println("teaching "+sub);
		
		Consumer<String> consumer = s->System.out.println("teaching "+s);
		
		System.out.println("teaching end");
		
		return consumer;
	}

}
