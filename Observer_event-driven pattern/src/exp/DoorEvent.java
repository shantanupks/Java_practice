package exp;

import java.util.ArrayList;

public class DoorEvent {
	
	 private int floorNo;
	 private int doorNo;
	
	 Service service = new Service();
	 ArrayList<ListeningService> arr= new ArrayList<>();

	 
	 public DoorEvent(int floorNo, int doorNo) {
		 this.floorNo=floorNo;
		 this.doorNo=doorNo;
	 }
	 	 
	 public int getFloorNo() {
		return floorNo;
	}

	public int getDoorNo() {
		return doorNo;
	}
	
	public void addListeners(ListeningService listeners) {
		arr.add(listeners);
	}
	
	public void openDoor() {
		 System.out.println("Door opened->"+getFloorNo()+"\t"+getDoorNo());
		 for(ListeningService listeners  : arr) {
				listeners.on();
			}
		 
	 }
	 
	 public void closeDoor() {
		 System.out.println("Door closed->"+getFloorNo()+"\t"+getDoorNo());
		 for(ListeningService listeners  : arr) {
				listeners.off();		 
	 }
		 
	 }

}
