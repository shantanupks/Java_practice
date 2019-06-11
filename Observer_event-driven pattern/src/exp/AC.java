package exp;

public class AC implements ListeningService {
	@Override
	public void on(DoorEvent event) {
		// TODO Auto-generated method stub
		System.out.println("AC turned on"+event.getDoorNo()+"\t"+event.getFloorNo());
	}
	
	@Override
	public void off(DoorEvent event) {
		// TODO Auto-generated method stub
		System.out.println("AC turned off"+event.getDoorNo()+"\t"+event.getFloorNo());
	}

}
