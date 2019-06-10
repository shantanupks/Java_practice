package exp;

import java.util.ArrayList;

public class DoorEvent {
	
	 private int floorNo;
	 private int doorNo;
	
	 Service service = new Service();

	 
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
	
}
