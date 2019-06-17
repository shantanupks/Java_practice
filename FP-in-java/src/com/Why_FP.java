package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Why_FP {
	static List<Product> products = new ArrayList<>();
	
	static {
		products.add(new Product(321434, "item-1", 1000.00));
		products.add(new Product(421431, "item-2", 3000.00));
		products.add(new Product(221433, "item-3", 7000.00));
		products.add(new Product(621437, "item-4", 1000.00));
		products.add(new Product(821436, "item-5", 5000.00));
	}
	
//	private static List<Product> getProducts(double price){
//		class ByPrice implements Predicate<Product>{
//
//			@Override
//			public boolean test(Product t) {
//				// TODO Auto-generated method stub
//				
//				return t.getPrice()==price;
//			}
//			
//		}
//		Predicate<Product> byPrice = new ByPrice();
//		return Lib.filter(products,byPrice);		
//		
//	}
	
	private static List<Product> getProducts(double price){
		
//		Predicate<Product> byPrice = new Predicate<Product>() {
//			@Override
//			public boolean test(Product t) {
//				// TODO Auto-generated method stub
//				return t.getPrice()==price;
//			}
//		};
		
//		
//		Predicate<Product> byPrice = public boolean test(Product t) {
//			return t.getPrice()==price;
//		}
		
//		Predicate<Product> byPrice = test(Product t){
//			return t.getPrice()==price;
//		}
//		
		
//		Predicate<Product> byPrice = (Product t){
//			return t.getPrice()==price;
//		}
		
		
		
		
		
//		
//		Predicate<Product> byPrice = (Product t) ->{
//			return t.getPrice()==price;
//		};
//		return Lib.filter(products, byPrice);
		
//		or
		
//		Predicate<Product> byPrice = (t)->{
//			return t.getPrice()==price;
//		};
		
		
		return Lib.filter(products, t->t.getPrice()==price);
		
		
	}
	public static void main(String[] args) {
		//products = getProducts(1000.00);
		products = getProducts(1000.00,3000.00);
		System.out.println(products);
		
	}
	private static List<Product> getProducts(double d, double e) {
		// TODO Auto-generated method stub
		return Lib.filter(products, t->t.getPrice()>=d && t.getPrice()<=e);
	}
	
	

}
