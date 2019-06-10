package exp;

// observer/lister/event-driven pattern

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoorEvent door = new DoorEvent(1,2);
		ListeningService ac = new AC();
		ListeningService lighting = new Lighting();
		
		door.addListeners(ac);
		door.addListeners(lighting);
				
		door.openDoor();
		
		System.out.println();
		
		door.closeDoor();
		
		

	}

}
