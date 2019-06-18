package com;

import java.util.ArrayList;
import java.util.List;


public class Q1 {
	
	public static  List<String> removeItem(List<String> menu){
		
		return Lib2.filter(menu, t->t.equals("nveg"));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> menu = new ArrayList<>();
		
		menu.add("nveg");
		menu.add("veg");
		menu.add("veg");
		menu.add("nveg");
		menu.add("veg");
		menu.add("nveg");		
		menu.add("veg");

//		
//		List<String> menu2 = new ArrayList<>();
//		menu2 = removeItem(menu);
//		System.out.println(menu2);
		
		menu.removeIf(item->item.equals("nveg"));
		System.out.println(menu);
		




	}

}
