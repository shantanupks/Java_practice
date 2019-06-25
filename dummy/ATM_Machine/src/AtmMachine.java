import java.util.HashMap;
import java.util.Map;

interface Despenser {
	public Map<Integer, Integer> withdraw(int i) throws NotSufficientAmount;
}

class NoteDespenser implements Despenser {
	private int totalNotesAvailable;
	private final int value;
	private NoteDespenser nextDespenser;

	public NoteDespenser(int value, int totalNotesAvailable, NoteDespenser nextNoteDespenser) {
		this.value = value;
		this.totalNotesAvailable = totalNotesAvailable;
		this.nextDespenser = nextNoteDespenser;
	}

	@Override
	public Map<Integer, Integer> withdraw(int amt) throws NotSufficientAmount {

		Map<Integer, Integer> notes = new HashMap<>();
		int requireNotesToWithDraw = amt / value;

		requireNotesToWithDraw = (totalNotesAvailable > requireNotesToWithDraw )? requireNotesToWithDraw : totalNotesAvailable;
		if ( requireNotesToWithDraw > 0) {
			totalNotesAvailable -= requireNotesToWithDraw;
			amt -= requireNotesToWithDraw * value;
			notes.put(value, requireNotesToWithDraw);
		}

		Map<Integer, Integer> furtherNotes;

		if (amt == 0) 
			return notes;
	
		assert(amt > 0);
			
		if (this.nextDespenser == null)
			throw new NotSufficientAmount();

		furtherNotes = this.nextDespenser.withdraw(amt);
		notes.putAll(furtherNotes);
	
		return notes;
	}

}

public class AtmMachine {

	private NoteDespenser noteDespenser;

	public AtmMachine() {
		NoteDespenser note100Desp = new NoteDespenser(100, 10, null);
		NoteDespenser note200Desp = new NoteDespenser(200, 20, note100Desp);
		NoteDespenser note500Desp = new NoteDespenser(500, 30, note200Desp);
		NoteDespenser note1000Desp = new NoteDespenser(1000, 60, note500Desp);
		NoteDespenser note2000Desp = new NoteDespenser(2000, 3, note1000Desp);

		this.noteDespenser = note2000Desp;
	}

	public Map<Integer, Integer> withdraw(int amt) {
		try {
			return this.noteDespenser.withdraw(amt);
		} catch (NotSufficientAmount e) {
			System.out.println("Dear customer, we don't have sufficient balance to process your request");
		}

		return null;
	}

	public static void main(String[] args) {
		AtmMachine machine = new AtmMachine();

		Map<Integer, Integer> notes = machine.withdraw(500000);

		System.out.println(notes);
	}
}
