package exp;

import java.util.ArrayList;

public class Door {
	 ArrayList<ListeningService> arr= new ArrayList<>();


	public void addListeners(ListeningService listeners) {
		arr.add(listeners);
	}
	
	public void openDoor() {
		 System.out.println("Door opened");
		 DoorEvent event = new DoorEvent();
		 
		 
		 
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
