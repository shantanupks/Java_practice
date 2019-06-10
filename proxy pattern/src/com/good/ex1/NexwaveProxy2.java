package com.good.ex1;

public class NexwaveProxy2 implements Service{
	
	Auth auth = new Auth();
	Nexwave nexwave = new Nexwave();
	
	@Override
	public void doLearn() {
		// TODO Auto-generated method stub
		auth.authorize();
		nexwave.doLearn();
	}
	
	@Override
	public void doLab() {
		// TODO Auto-generated method stub
		auth.authorize();
		nexwave.doLab();
	}

}
