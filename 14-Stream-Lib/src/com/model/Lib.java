package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lib<E, R> {

	public static <E> List<E> filter(List<E> inp, Predicate<E> predicate) {
		List<E> result = new ArrayList<E>();
		
		for(E e: inp) {
			{
				if(predicate.test(e))
				result.add(e);
				
				
				
				
			}
		}
		return result;

	}
	
	public static <E, R> List<R> map(List<E> inp, Function<E, R> function) {
		List<R> res = new ArrayList<R>();
			for(E e : inp) {
				res.add(function.apply(e));
			}
			return res;
		}
	public static <E> void forEach(List<E> inp, Consumer<E> consumer) {
		for(E e:inp) {
			consumer.accept(e);
		}
	}
	

	
	
}
