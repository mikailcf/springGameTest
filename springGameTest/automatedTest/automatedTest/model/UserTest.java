package automatedTest.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.Constants;
import springGameTest.model.EntityProperties;
import springGameTest.model.Event;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.model.User;
import springGameTest.model.WrongTypeException;
import springGameTest.service.EventService;
import springGameTest.service.InventoryService;
import springGameTest.service.PropertyService;

public class UserTest {
	
	private long testUserId = 12;
	private EntityProperties testProperties = new EntityProperties();
	private Inventory testInventory = new Inventory();
	private Inventory testRecipes = new Inventory();
	private User testUser = new User(testUserId);

	private String testName1 = "testName1";
	private String testName2 = "testName2";
	private String testName3 = "testName3";
	private String testName4 = "testName4";
	private String testName5 = "testName5";
	private long testValue1 = 22;
	private double testValue2 = -17.9;
	private String testValue3 = "testValue3";
	private Date testValue4 = new Date();
	private Property testProperty1 = new Property(testName1, testValue1);
	private Property testProperty2 = new Property(testName2, testValue2);
	private Property testProperty3 = new Property(testName3, testValue3);
	private Property testProperty4 = new Property(testName4, testValue4);	
	
	@Before
	public void setUp() {
		PropertyService.addProperty(testUser.getProperties(), testProperty1);
		PropertyService.addProperty(testUser.getProperties(), testProperty2);
		PropertyService.addProperty(testUser.getProperties(), testProperty3);
		PropertyService.addProperty(testUser.getProperties(), testProperty4);
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
		assertTrue(testUser.getUserId() == testUserId);
	}

	@Test
	public final void test02() {
		PropertyService.addProperty(testProperties, testProperty1);
		PropertyService.addProperty(testProperties, testProperty2);
		PropertyService.addProperty(testProperties, testProperty3);
		PropertyService.addProperty(testProperties, testProperty4);
		assertTrue(testUser.getProperties().equals(testProperties));
	}

	@Test
	public final void test03() {
		String testItemType = Constants.objectName;
		Item testItem1 = new Item(testItemType);
		Item testItem2 = new Item(testItemType);
		testItem1.setName(testName1);
		testItem2.setName(testName2);
		testRecipes.addItem(testItem1, InventoryService.getItemName(testItem1));
		testUser.getRecipes().addItem(testItem1, InventoryService.getItemName(testItem1));
		testRecipes.addItem(testItem2, InventoryService.getItemName(testItem2));
		testUser.getRecipes().addItem(testItem2, InventoryService.getItemName(testItem2));
		assertTrue(testUser.getInventory().equals(testInventory));
	}

	@Test
	public final void test04() {
		String testItemType = Constants.objectName;
		Item testItem1 = new Item(testItemType);
		Item testItem2 = new Item(testItemType);
		testItem1.setName(testName1);
		testItem2.setName(testName2);
		testRecipes.addItem(testItem1, InventoryService.getItemName(testItem1));
		testUser.getRecipes().addItem(testItem1, InventoryService.getItemName(testItem1));
		testRecipes.addItem(testItem2, InventoryService.getItemName(testItem2));
		testUser.getRecipes().addItem(testItem2, InventoryService.getItemName(testItem2));
		assertTrue(testUser.getRecipes().equals(testRecipes));
	}

	@Test
	public final void test05() {
		Event testEvent1 = new Event(testName1);
		Event testEvent2 = new Event(testName2);
		EventService.addEventToUser(testUser, testEvent1);
		EventService.addEventToUser(testUser, testEvent2);
		assertTrue(testUser.getEventList().contains(testEvent1));
	}

	@Test
	public final void test06() {
		Event testEvent1 = new Event(testName1);
		Event testEvent2 = new Event(testName2);
		EventService.addEventToUser(testUser, testEvent1);
		EventService.addEventToUser(testUser, testEvent2);
		assertTrue(testUser.getEventList().contains(testEvent2));
	}

	@Test
	public final void test07() {
		Event testEvent1 = new Event(testName1);
		Event testEvent2 = new Event(testName2);
		Event testEvent3 = new Event(testName3);
		EventService.addEventToUser(testUser, testEvent1);
		EventService.addEventToUser(testUser, testEvent2);
		assertFalse(testUser.getEventList().contains(testEvent3));
	}

	@Test
	public final void test08() {
		assertTrue(testUser.getIntValue(testName1) == testValue1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test09() {
		testUser.getIntValue(testName2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test10() {
		testUser.getIntValue(testName3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test11() {
		testUser.getIntValue(testName4);
	}

	@Test (expected = NullPointerException.class)
	public final void test12() {
		testUser.getIntValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test13() {
		testUser.getFloatValue(testName1);
	}

	@Test
	public final void test14() {
		assertTrue(testUser.getFloatValue(testName2) == testValue2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test15() {
		testUser.getFloatValue(testName3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test16() {
		testUser.getFloatValue(testName4);
	}

	@Test (expected = NullPointerException.class)
	public final void test17() {
		testUser.getFloatValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test18() {
		testUser.getStringValue(testName1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test19() {
		testUser.getStringValue(testName2);
	}

	@Test
	public final void test20() {
		assertTrue(testUser.getStringValue(testName3) == testValue3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test21() {
		testUser.getStringValue(testName4);
	}

	@Test (expected = NullPointerException.class)
	public final void test22() {
		testUser.getStringValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test23() {
		testUser.getDateValue(testName1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test24() {
		testUser.getDateValue(testName2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test25() {
		testUser.getDateValue(testName3);
	}

	@Test
	public final void test26() {
		assertTrue(testUser.getDateValue(testName4) == testValue4);
	}

	@Test (expected = NullPointerException.class)
	public final void test27() {
		testUser.getDateValue(testName5);
	}

	@Test
	public final void test28() {
		assertTrue(testUser.hasProperty(testName1));
	}

	@Test
	public final void test29() {
		assertFalse(testUser.hasProperty(testName5));
	}

}
