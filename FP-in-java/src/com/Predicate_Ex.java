package com;

import java.util.function.Predicate;

public class Predicate_Ex {
	public static void main(String[] args) {
		
		
		
		Predicate<Integer> predicate = i->i>70;
		Predicate<Integer> predicate2 = i->i<100;
		Predicate<Integer> predicate4 = i-> i<120;
		
		Predicate<Integer> predicate3 = predicate.or(predicate2).negate();
		
		boolean b = predicate3.test(80);
		System.out.println(b);

	}

}
