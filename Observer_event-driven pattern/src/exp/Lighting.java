package exp;

public class Lighting implements ListeningService {
	
	@Override
	public void on(DoorEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Lighting turned on->"+event.getDoorNo()+"\t"+event.getFloorNo());
		
	}
	
	@Override
	public void off(DoorEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Lighting turned off"+event.getDoorNo()+"\t"+event.getFloorNo());

	}
	
}
