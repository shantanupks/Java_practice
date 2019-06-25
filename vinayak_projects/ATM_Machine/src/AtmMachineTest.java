import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class AtmMachineTest {

	AtmMachine machine = new AtmMachine();
	 
	@Test
	void testWithdraw() {
		Map<Integer, Integer> notes = machine.withdraw(3200);
		
		Map<Integer, Integer> expectedNotes = new HashMap<>();
		expectedNotes.put(2000, 1);
		expectedNotes.put(1000, 1);
		expectedNotes.put(200, 1);
		
		assertEquals(expectedNotes, notes);
	}

	@Test
	void testWithdraw2() {
		Map<Integer, Integer> notes = machine.withdraw(3300);
		
		Map<Integer, Integer> expectedNotes = new HashMap<>();
		expectedNotes.put(2000, 1);
		expectedNotes.put(1000, 1);
		expectedNotes.put(200, 1);
		expectedNotes.put(100, 1);
		
		assertEquals(expectedNotes, notes);
	}
	
	@Test
	void testWithdraw3() {
		Map<Integer, Integer> notes = machine.withdraw(3800);
		
		Map<Integer, Integer> expectedNotes = new HashMap<>();
		expectedNotes.put(2000, 1);
		expectedNotes.put(1000, 1);
		expectedNotes.put(500, 1);
		expectedNotes.put(200, 1);
		expectedNotes.put(100, 1);
		
		assertEquals(expectedNotes, notes);
	}
	
	@Test
	void testException() {
		machine.withdraw(500000);
		
	}
}
