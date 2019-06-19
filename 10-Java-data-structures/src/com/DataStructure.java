package com;

import java.io.IOException;
import java.util.Iterator;


public class DataStructure {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		

		
		//list.reverse();
		list.removeEle(5);
		
		 //way-1 : iterator
//		Iterator <Integer> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Integer e = iterator.next();
//			System.out.println(e);
//		}
		
		System.out.println("--------------------------");

		
		//way-2 : for-each
		for(Integer i : list) {
			System.out.println(i);
		}
	
	
		
		
		

	}

}
