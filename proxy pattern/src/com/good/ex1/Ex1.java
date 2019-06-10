package com.good.ex1;

// proxy pattern
//way 1--> by inheritance
// way 2-->by composition  



public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		NexwaveProxy nexwaveProxy = new NexwaveProxy();
//		nexwaveProxy.doLearn();
//		
//		System.out.println();
//		
//		nexwaveProxy.doLab();
		
		NexwaveProxy2 nexwaveProxy2 = new NexwaveProxy2();
		nexwaveProxy2.doLearn();
		
		System.out.println();
		
		nexwaveProxy2.doLab();
		

}
}
