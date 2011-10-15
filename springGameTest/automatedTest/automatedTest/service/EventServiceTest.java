package automatedTest.service;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.Event;
import springGameTest.model.User;
import springGameTest.service.EventService;

public class EventServiceTest {

	private User testUser = new User(22, "testName1");
	private User testUser2 = new User(23, "testName2");
	private String testMessage1 = "testMessage1";
	private String testMessage2 = "testMessage2";
	private String testMessage3 = "testMessage3";
	private String testMessage4 = "testMessage4";
	private String testMessage5 = "testMessage5";
	private String testMessage6 = "testMessage6";
	private long minimum1 = 2;
	private long minimum2 = 8;
	private long amount1 = 1;
	private long amount2 = 4;
	private long amount3 = 10;
	private Collection<Event> eventList;

	@Before
	public void setUp() {
		EventService.addEventToUser(testUser2, testMessage1);
		EventService.addEventToUser(testUser2, testMessage2);
		EventService.addEventToUser(testUser2, testMessage3);
		EventService.addEventToUser(testUser2, testMessage4);
		EventService.addEventToUser(testUser2, testMessage5);
		EventService.addEventToUser(testUser2, testMessage6);
	}

	@After
	public void tearDown() {
	}

	@Test
	public final void test01() {
		EventService.addEventToUser(testUser, testMessage1);
		assertTrue(testUser.getEventList().size() == 1);
	}

	@Test
	public final void test02() {
		EventService.addEventToUser(testUser, testMessage1);
		assertTrue(testUser.getEventList().get(0).getMessage().equals(testMessage1));
	}

	@Test
	public final void test03() {
		EventService.addEventToUser(testUser, new Event(testMessage1));
		assertTrue(testUser.getEventList().size() == 1);
	}

	@Test
	public final void test04() {
		EventService.addEventToUser(testUser, new Event(testMessage1));
		assertTrue(testUser.getEventList().get(0).getMessage().equals(testMessage1));
	}

	@Test
	public final void test05() {
		eventList = EventService.getEventList(testUser2, amount1, minimum1);
		assertTrue(eventList.size() >= minimum1);
	}

	@Test
	public final void test06() {
		eventList = EventService.getEventList(testUser2, amount1, minimum1);
		assertTrue(eventList.size() <= Math.max(amount1, minimum1));
	}

	@Test
	public final void test07() {
		eventList = EventService.getEventList(testUser2, amount2, minimum1);
		assertTrue(eventList.size() >= minimum1);
	}

	@Test
	public final void test08() {
		eventList = EventService.getEventList(testUser2, amount2, minimum1);
		assertTrue(eventList.size() <= Math.max(amount2, minimum1));
	}

	@Test
	public final void test09() {
		eventList = EventService.getEventList(testUser2, amount3, minimum1);
		assertTrue(eventList.size() >= minimum1);
	}

	@Test
	public final void test10() {
		eventList = EventService.getEventList(testUser2, amount3, minimum1);
		assertTrue(eventList.size() <= Math.max(amount3, minimum1));
	}

	@Test
	public final void test11() {
		eventList = EventService.getEventList(testUser2, amount1, minimum2);
		assertTrue(eventList.size() >= minimum2);
	}

	@Test
	public final void test12() {
		eventList = EventService.getEventList(testUser2, amount1, minimum2);
		assertTrue(eventList.size() <= Math.max(amount1, minimum2));
	}

	@Test
	public final void test13() {
		eventList = EventService.getEventList(testUser2, amount2, minimum2);
		assertTrue(eventList.size() >= minimum2);
	}

	@Test
	public final void test14() {
		eventList = EventService.getEventList(testUser2, amount2, minimum2);
		assertTrue(eventList.size() <= Math.max(amount2, minimum2));
	}

	@Test
	public final void test15() {
		eventList = EventService.getEventList(testUser2, amount3, minimum2);
		assertTrue(eventList.size() >= minimum2);
	}

	@Test
	public final void test16() {
		eventList = EventService.getEventList(testUser2, amount3, minimum2);
		assertTrue(eventList.size() <= Math.max(amount3, minimum2));
	}

}
