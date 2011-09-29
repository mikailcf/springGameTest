package automatedTest.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.Constants;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.service.PropertyService;

public class InventoryTest {

	private long testItemID1 = 33;
	private long testItemID2 = 57;
	private long testItemID3 = 4;
	private String testName1 = "testName1";
	private String testName2 = "testName2";
	private String testName3 = "testName3";
	private Item testItem1 = new Item(testItemID1);
	private Item testItem2 = new Item(testItemID2);
	private Property testItemName1 = new Property(Constants.name, testName1);
	private Property testItemName2 = new Property(Constants.name, testName2);
	private Inventory testInventory = new Inventory();
	
	@Before
	public void setUp() {
		PropertyService.addProperty(testItem1.getProperties(), testItemName1);
		PropertyService.addProperty(testItem2.getProperties(), testItemName2);
		testInventory.addItem(testItem1, testName1);
		testInventory.addItem(testItem2, testName2);
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
		assertTrue(testInventory.getItemById(testItemID1).equals(testItem1));
	}

	@Test
	public final void test02() {
		assertTrue(testInventory.getItemById(testItemID2).equals(testItem2));
	}

	@Test
	public final void test03() {
		assertTrue(testInventory.getItemById(testItemID3) == null);
	}

	@Test
	public final void test04() {
		assertTrue(testInventory.getItemById(new Integer(""+testItemID1)).
				equals(testItem1));
	}

	@Test
	public final void test05() {
		assertTrue(testInventory.getItemById(new Integer(""+testItemID2)).
				equals(testItem2));
	}

	@Test
	public final void test06() {
		assertTrue(testInventory.getItemById(new Integer(""+testItemID3)) == null);
	}

	@Test
	public final void test07() {
		assertTrue(testInventory.getItemByName(testName1).equals(testItem1));
	}

	@Test
	public final void test08() {
		assertTrue(testInventory.getItemByName(testName2).equals(testItem2));
	}

	@Test
	public final void test09() {
		assertTrue(testInventory.getItemByName(testName3) == null);
	}

	@Test
	public final void test10() {
		testInventory.removeById(testItemID1);
		assertTrue(testInventory.getItemById(testItemID1) == null);
	}

	@Test
	public final void test11() {
		testInventory.removeById(testItemID1);
		assertTrue(testInventory.getItemById(new Integer(""+testItemID1)) == null);
	}

	@Test
	public final void test12() {
		testInventory.removeById(testItemID1);
		assertTrue(testInventory.getItemByName(testName1) == null);
	}

	@Test
	public final void test13() {
		testInventory.removeById(new Integer(""+testItemID1));
		assertTrue(testInventory.getItemById(testItemID1) == null);
	}

	@Test
	public final void test14() {
		testInventory.removeById(new Integer(""+testItemID1));
		assertTrue(testInventory.getItemById(new Integer(""+testItemID1)) == null);
	}

	@Test
	public final void test15() {
		testInventory.removeById(new Integer(""+testItemID1));
		assertTrue(testInventory.getItemByName(testName1) == null);
	}

	@Test
	public final void test16() {
		testInventory.removeByName(testName1);
		assertTrue(testInventory.getItemById(testItemID1) == null);
	}

	@Test
	public final void test17() {
		testInventory.removeByName(testName1);
		assertTrue(testInventory.getItemById(new Integer(""+testItemID1)) == null);
	}

	@Test
	public final void test18() {
		testInventory.removeByName(testName1);
		assertTrue(testInventory.getItemByName(testName1) == null);
	}

	@Test
	public final void test19() {
		assertTrue(testInventory.getItemList().contains(testItem1));
	}

	@Test
	public final void test20() {
		assertTrue(testInventory.getItemList().contains(testItem2));
	}

	@Test
	public final void test21() {
		Item testItem3 = new Item(testItemID3);
		PropertyService.addProperty(testItem3.getProperties(),
				new Property(Constants.name, testName3));
		assertFalse(testInventory.getItemList().contains(testItem3));
	}

	@Test
	public final void test22() {
		Inventory testInventory2 = new Inventory();
		testInventory2.addItem(testItem1, testName1);
		testInventory2.addItem(testItem2, testName2);
		assertTrue(testInventory.equals(testInventory2));
	}

	@Test
	public final void test23() {
		Inventory testInventory2 = new Inventory();
		testInventory2.addItem(testItem2, testName2);
		testInventory2.addItem(testItem1, testName1);
		assertTrue(testInventory.equals(testInventory2));
	}

	@Test
	public final void test24() {
		Inventory testInventory2 = new Inventory();
		testInventory2.addItem(testItem2, testName2);
		assertFalse(testInventory.equals(testInventory2));
	}

	@Test
	public final void test25() {
		Inventory testInventory2 = new Inventory();
		testInventory2.addItem(testItem1, testName1);
		testInventory2.addItem(testItem2, testName2);
		Item testItem3 = new Item(testItemID3);
		PropertyService.addProperty(testItem3.getProperties(),
				new Property(Constants.name, testName3));
		testInventory2.addItem(testItem3, testName3);
		assertFalse(testInventory.equals(testInventory2));
	}

}
