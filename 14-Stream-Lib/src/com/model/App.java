package com.model;

import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		
		
		List<Product> list = Arrays.asList(
				new Product(12312, "item-1", 1000.00),
				new Product(12354, "item-2", 3000.00),
				new Product(17812, "item-3", 7000.00),
				new Product(78312, "item-4", 2000.00),
				new Product(12982, "item-5", 8000.00),
				new Product(78312, "item-6", 4000.00)
				);
		
		double result=0;		
		
		for(Product product : list) {
			if(product.getPrice()>3000) {
				result = result + product.getPrice();
			}
		}
		
		List<Product> r1=Lib.filter(list, e->e.price>5000);
		List<String> r2 =Lib.map(r1, e->e.getName());
		
		
		Lib.forEach(r2, e->System.out.println(" "+e));
		
		
					
		
	}

}
