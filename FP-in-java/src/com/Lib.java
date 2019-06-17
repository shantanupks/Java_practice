package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lib {
	
	public static List<Product> filter(List<Product> inp, Predicate<Product> predicate ){
		List<Product> out = new ArrayList<Product>();
		for(Product product : inp) {
			if(predicate.test(product)){
				out.add(product);
			}
		}
		return out;
		
		
	}

}
