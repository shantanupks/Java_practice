package com;

public class FivehunDispenser implements Chain{
	int value = 500;


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
				System.out.println("Dispensing "+num+" 500 notes ");
				
				if(remainder!=0) {
					cur.amount = remainder; 
					this.next.process(cur);
				}
				
				}else {
					this.next.process(cur);
				}
				
		}

}
