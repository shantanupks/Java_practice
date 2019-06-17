package com;

public class App_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chain c1 = new TwokDispenser();
		Chain c2 = new FivehunDispenser();
		Chain c3 = new HundreadDispenser();
		c1.setNext(c2);
		c2.setNext(c3);
		
		Currency cur = new Currency(3500);
		c1.process(cur);
		
	}

}
