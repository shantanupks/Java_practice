package com;

import java.util.function.Predicate;

@FunctionalInterface
interface StringToIntMapper{
	int map(String s);
}

public class How_To_Write_Function {
	public static void main(String[] args) {
			
	Predicate<Product> predicate = (t) -> t.getPrice() == 1000.00;
	boolean b = predicate.test(new Product(111, "Item", 1000.00));
	
	System.out.println(b);
	
	
//	StringToIntMapper mapper = (String s) -> { 
//		return s.length();
//	};
//	
//	or
//	
//	StringToIntMapper mapper = (s)->{
//		return s.length();
//	};
//	or
	
//	StringToIntMapper mapper = s-> {
//		return s.length();
//	};
//	or
	
			StringToIntMapper mapper = s->s.length();
			System.out.println(mapper.map("sjddjs"));
			
			
			
			
	}


}
