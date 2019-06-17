package com;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Lib2 {
	
	public static List<String> filter(List<String> inp, Predicate<String> predicate ){
		Iterator<String> it = inp.iterator();
		
		while(it.hasNext()) {
			String item = it.next();
			if(predicate.test(item)) {
				it.remove();
			}
		}
		
		return inp;
	}

}
