package exp;

public class Lighting implements ListeningService {

	@Override
	public void on() {
		// TODO Auto-generated method stub
		System.out.println("Lighting turned on");
		
	}
	
	@Override
	public void off() {
		// TODO Auto-generated method stub
		System.out.println("Lighting turned off");
	}

}
