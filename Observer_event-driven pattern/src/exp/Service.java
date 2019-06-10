package exp;

import java.util.ArrayList;

public class Service{
	
	ArrayList<ListeningService> arr= new ArrayList<>();
	
	AC ac = new AC();
	Lighting lighting = new Lighting();
	
	
	
	
	
	public void onService() {
		
	}
	
	public void offService() {
		ac.off();
		lighting.off();
		
	}
	
	

}
