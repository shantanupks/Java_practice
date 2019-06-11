package exp;

import java.util.ArrayList;

public class Door {
	 ArrayList<ListeningService> arr= new ArrayList<>();


	public void addListeners(ListeningService listeners) {
		arr.add(listeners);
	}
	
	public void openDoor() {
		 System.out.println("Door opened");
		 DoorEvent event = new DoorEvent(4,5);
		 		 
		 for(ListeningService listeners  : arr) {
				listeners.on(event);
			}
		 
	 }
	 
	 public void closeDoor() {
		 System.out.println("Door opened");
		 DoorEvent event = new DoorEvent(4,5);
		 for(ListeningService listeners  : arr) {
				listeners.off(event);		 
	 }		 

}
}
