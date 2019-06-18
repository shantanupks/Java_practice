package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product2 implements Comparable<Product2>{
	int id;
	String name;
	
	
	public Product2(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	


	@Override
	public String toString() {
		return "Product2 [id=" + id + ", name=" + name + "]";
	}



	@Override
	public int compareTo(Product2 o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class Comparable_Ex {
	public static void main(String[] args) {
		
		Product2 product = new Product2(1,"abc");
		Product2 product2 = new Product2(2,"jdsk");
		Product2 product3 = new Product2(3,"sdjhj");
		Product2 product4 = new Product2(3,"adjhj");

		
		List<Product2> list = new ArrayList<Product2>();
		list.add(null);
		list.add(product3);
		list.add(product2);
		list.add(product);
		list.add(product4);

		
//		Comparator<Product2> comparator = new Comparator<Product2>() {
//
//			@Override
//			public int compare(Product2 o1, Product2 o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		};
		
		Comparator<Product2> byPrice = (o1,o2)->Integer.compare(o1.id, o2.id);
		
		Comparator<Product2> byName = (o1,o2)->o1.name.compareTo(o2.name);
		
		Comparator<Product2> byPriceAndbyName = byPrice.thenComparing(byName);
		
		byPriceAndbyName=Comparator.nullsFirst(byPriceAndbyName);
		
		byPriceAndbyName.reversed();
		
		Collections.sort(list,byPriceAndbyName);
		
		
		
				
		list.forEach(System.out::println);
		
		
		
	}

}
