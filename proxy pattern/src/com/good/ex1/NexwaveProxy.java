package com.good.ex1;

public class NexwaveProxy extends Nexwave {
	
	Auth auth = new Auth();
	
	@Override
	public void doLearn() {
		// TODO Auto-generated method stub
		auth.authorize();
		super.doLearn();
	}
	
	
	@Override
	public void doLab() {
		// TODO Auto-generated method stub
		auth.authorize();
		super.doLab();
	}

}
