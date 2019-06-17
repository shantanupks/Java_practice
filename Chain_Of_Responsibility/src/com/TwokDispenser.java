package com;

public class TwokDispenser implements Chain{
	
	int value = 2000;
	

	private Chain next ;
	 @Override
	public void setNext(Chain next) {
		// TODO Auto-generated method stub
		 this.next=next;
	}
	 
	 @Override
	public void process(Currency cur) {
		// TODO Auto-generated method stub
		if(cur.amount>=this.value) {
			int num = cur.amount/this.value;
			int remainder  = cur.amount % this.value;
			System.out.println("Dispensing "+num+" 2000 notes ");
			
			if(remainder!=0) {
				cur.amount = remainder; 
				this.next.process(cur);
			}
			}else {
				this.next.process(cur);
			}
			
	}
	
}
