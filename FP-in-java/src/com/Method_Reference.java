package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Method_Reference {
	
	public static boolean isNonVeg(String s) {
		return s.equals("nveg");
		
	}
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("veg");
		list.add("nveg");
		list.add("veg");
		list.add("veg");
		list.add("nveg");
		list.add("veg");
		
		//list.removeIf(s->s.equals("nveg"));
		
		//list.removeIf(s->Method_Reference.isNonVeg(s));
		
		
		Predicate<String> predicate = Method_Reference::isNonVeg;
		
		
		list.removeIf(predicate);
		
		System.out.println(list);
		
		
		
		Function<String, Integer> function = String::length;		

		
	}
	
	

}
