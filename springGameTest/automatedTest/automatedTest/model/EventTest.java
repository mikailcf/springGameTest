package automatedTest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.Event;

public class EventTest {
	
	private String testMessage = "testMessage";
	private String emptyMessage = "";
	private Event testEvent = new Event(testMessage);
	private Event emptyEvent = new Event(emptyMessage);
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
		assertTrue(testEvent.isNew());
	}

	@Test
	public final void test02() {
		assertTrue(emptyEvent.isNew());
	}

	@Test
	public final void test03() {
		assertFalse(testEvent.isEmpty());
	}

	@Test
	public final void test04() {
		assertTrue(emptyEvent.isEmpty());
	}

	@Test
	public final void test05() {
		assertTrue(testEvent.getMessage().equals(testMessage));
	}

	@Test
	public final void test06() {
		assertTrue(emptyEvent.getMessage().equals(emptyMessage));
	}

	@Test
	public final void test07() {
		testEvent.getMessage();
		assertFalse(testEvent.isNew());
	}

	@Test
	public final void test08() {
		emptyEvent.getMessage();
		assertFalse(emptyEvent.isNew());
	}

}
