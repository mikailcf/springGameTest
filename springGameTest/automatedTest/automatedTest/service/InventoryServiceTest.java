package automatedTest.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.Constants;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.service.InventoryService;
import springGameTest.service.ItemCollisionAction;
import springGameTest.service.PropertyService;
import springGameTest.test.GameMock;

public class InventoryServiceTest {
	
	private String testName = "testName";
	private String testItemType = Constants.objectName;
	private Item testItem;
	private Inventory testInventory = new Inventory();
	
	@Before
	public void setUp() {
		GameMock.initializeItemTypeHierarchy();
		testItem = new Item(testItemType);
	}

	@After
	public void tearDown() {
	}

	@Test
	public final void test01() {
		assertTrue(InventoryService.getItemQuantity(testItem) == 1);
	}

	@Test
	public final void test02() {
		long testQuantity = 12;
		testItem.setQuantity(testQuantity);
		assertTrue(InventoryService.getItemQuantity(testItem) == testQuantity);
	}

	@Test
	public final void test03() {
		assertTrue(InventoryService.getItemName(testItem).equals(testItemType));
	}

	@Test
	public final void test04() {
		testItem.setName(testName);
		assertTrue(InventoryService.getItemName(testItem) == testName);
	}

	@Test (expected = NullPointerException.class)
	public final void test05() {
		InventoryService.getResourcesNeeded(testItem);
	}

	@Test
	public final void test06() {
		long testResourcesNeeded = 12;
		PropertyService.addProperty(testItem.getProperties(),
				new Property(Constants.resourcesNeeded, testResourcesNeeded));
		assertTrue(InventoryService.getResourcesNeeded(testItem)
				== testResourcesNeeded);
	}

	@Test
	public final void test07() {
		double multiplier = 1.0;
		assertTrue(InventoryService.getBuyValue(testItem, multiplier) == 0);
	}

	@Test
	public final void test08() {
		long testItemValue = 12;
		double multiplier = 1.0;
		testItem.setValue(testItemValue);
		assertTrue(InventoryService.getBuyValue(testItem, multiplier) >= 1);
	}

	@Test
	public final void test09() {
		double multiplier = 1.0;
		assertTrue(InventoryService.getSellValue(testItem, multiplier) == 0);
	}

	@Test
	public final void test10() {
		long testItemValue = 12;
		double multiplier = 1.0;
		testItem.setValue(testItemValue);
		assertTrue(InventoryService.getSellValue(testItem, multiplier) >= 1);
	}

	@Test
	public final void test11() {
		double mean = 82.1;
		InventoryService.getRandomRating(mean);
	}

	@Test (expected = NullPointerException.class)
	public final void test12() {
		InventoryService.getAbsoluteValue(testItem, testName);
	}

	@Test
	public final void test13() {
		double testValue = 1.8;
		PropertyService.addProperty(testItem.getProperties(),
				new Property(testName, testValue));
		InventoryService.getAbsoluteValue(testItem, testName);
	}

	@Test (expected=NullPointerException.class)
	public final void test14() {
		InventoryService.getPercentageValue(testItem, testName);
	}

	@Test (expected=NullPointerException.class)
	public final void test15() {
		double testValue = 1.8;
		PropertyService.addProperty(testItem.getProperties(),
				new Property(testName, testValue));
		InventoryService.getPercentageValue(testItem, testName);
	}

	@Test (expected=NullPointerException.class)
	public final void test16() {
		double testValue = 1.8;
		PropertyService.addProperty(testItem.getProperties(),
				new Property(Constants.expectedRating, testValue));
		InventoryService.getPercentageValue(testItem, testName);
	}

	@Test
	public final void test17() {
		double testValue = 1.8;
		PropertyService.addProperty(testItem.getProperties(),
				new Property(testName, testValue));
		PropertyService.addProperty(testItem.getProperties(),
				new Property(Constants.expectedRating, testValue));
		InventoryService.getPercentageValue(testItem, testName);
	}

	@Test
	public final void test18() {
		String testNameTin = "Tin";
		long testQuantity = 41;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		InventoryService.addItem(testInventory, testItem, testQuantity);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == testQuantity);
	}

	@Test
	public final void test19() {
		String testNameTin = "Tin";
		long testQuantity1 = 41;
		long testQuantity2 = 12;
		Item testItemTin = 
				Item.itemTemplateList.getItemByName(testNameTin).copyNewId();
		InventoryService.addItem(testInventory, testItemTin, testQuantity1);
		InventoryService.addItem(testInventory, testItemTin, testQuantity2);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == testQuantity1 + testQuantity2);
	}

	@Test
	public final void test20() {
		String testNameTin = "Tin";
		long testQuantity1 = 41;
		long testQuantity2 = 12;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testItem.setQuantity(testQuantity1); 
		testInventory.addItem(testItem, testNameTin);
		String testNameCopper = "Copper";
		String testItemType = Constants.objectName;
		Item testItemCopper = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameCopper).copy(testItemCopper);
		InventoryService.addItem(testInventory, testItemCopper, testQuantity2);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == testQuantity1);
	}

	@Test
	public final void test21() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		InventoryService.addItem(testInventory, testItem);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test22() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		testInventory.addItem(testItem, testNameDagger);
		String testNameSword = "Sword";
		String testItemType = Constants.objectName;
		Item testItemSword = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameSword).copy(testItemSword);
		InventoryService.addItem(testInventory, testItemSword);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test23() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		InventoryService.addItem(testInventory, testItem);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test24() {
		String testNameTin = "Tin";
		Item testItemTin =
				Item.itemTemplateList.getItemByName(testNameTin).copyNewId();
		InventoryService.addItem(testInventory, testItemTin);
		InventoryService.addItem(testInventory, testItemTin);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1 + 1);
	}

	@Test
	public final void test25() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testInventory.addItem(testItem, testNameTin);
		String testNameCopper = "Copper";
		String testItemType = Constants.objectName;
		Item testItemCopper = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameCopper).copy(testItemCopper);
		InventoryService.addItem(testInventory, testItemCopper);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test26() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.ExistingPrevails);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test27() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		testInventory.addItem(testItem, testNameDagger);
		String testNameSword = "Sword";
		String testItemType = Constants.objectName;
		Item testItemSword = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameSword).copy(testItemSword);
		InventoryService.addItem(testInventory, testItemSword,
				ItemCollisionAction.ExistingPrevails);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test28() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.ExistingPrevails);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test29() {
		String testNameTin = "Tin";
		long testQuantity1 = 27;
		long testQuantity2 = 3;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testItem.setQuantity(testQuantity1);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.ExistingPrevails);
		String testItemType = Constants.objectName;
		Item testItemTin = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItemTin);
		testItemTin.setQuantity(testQuantity2);
		InventoryService.addItem(testInventory, testItemTin,
				ItemCollisionAction.ExistingPrevails);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == testQuantity1);
	}

	@Test
	public final void test30() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testInventory.addItem(testItem, testNameTin);
		String testNameCopper = "Copper";
		String testItemType = Constants.objectName;
		Item testItemCopper = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameCopper).copy(testItemCopper);
		InventoryService.addItem(testInventory, testItemCopper,
				ItemCollisionAction.ExistingPrevails);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test31() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.NewPrevails);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test32() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		testInventory.addItem(testItem, testNameDagger);
		String testNameSword = "Sword";
		String testItemType = Constants.objectName;
		Item testItemSword = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameSword).copy(testItemSword);
		InventoryService.addItem(testInventory, testItemSword,
				ItemCollisionAction.NewPrevails);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test33() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.NewPrevails);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test34() {
		String testNameTin = "Tin";
		long testQuantity1 = 27;
		long testQuantity2 = 3;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testItem.setQuantity(testQuantity1);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.NewPrevails);
		String testItemType = Constants.objectName;
		Item testItemTin = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItemTin);
		testItemTin.setQuantity(testQuantity2);
		InventoryService.addItem(testInventory, testItemTin,
				ItemCollisionAction.NewPrevails);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == testQuantity2);
	}

	@Test
	public final void test35() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testInventory.addItem(testItem, testNameTin);
		String testNameCopper = "Copper";
		String testItemType = Constants.objectName;
		Item testItemCopper = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameCopper).copy(testItemCopper);
		InventoryService.addItem(testInventory, testItemCopper,
				ItemCollisionAction.NewPrevails);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test36() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.Include);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test37() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		testInventory.addItem(testItem, testNameDagger);
		String testNameSword = "Sword";
		String testItemType = Constants.objectName;
		Item testItemSword = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameSword).copy(testItemSword);
		InventoryService.addItem(testInventory, testItemSword,
				ItemCollisionAction.Include);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test38() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.Include);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test39() {
		String testNameTin = "Tin";
		long testQuantity1 = 27;
		long testQuantity2 = 3;
		Item testItemTin1 =
				Item.itemTemplateList.getItemByName(testNameTin).copyNewId();
		testItemTin1.setQuantity(testQuantity1);
		InventoryService.addItem(testInventory, testItemTin1,
				ItemCollisionAction.Include);
		Item testItemTin2 =
				Item.itemTemplateList.getItemByName(testNameTin).copyNewId();
		testItemTin2.setQuantity(testQuantity2);
		InventoryService.addItem(testInventory, testItemTin2,
				ItemCollisionAction.Include);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin))
				== testQuantity1 + testQuantity2);
	}

	@Test
	public final void test40() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testInventory.addItem(testItem, testNameTin);
		String testNameCopper = "Copper";
		String testItemType = Constants.objectName;
		Item testItemCopper = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameCopper).copy(testItemCopper);
		InventoryService.addItem(testInventory, testItemCopper,
				ItemCollisionAction.Include);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test41() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.Stack);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test42() {
		String testNameDagger = "Dagger";
		Item.itemTemplateList.getItemByName(testNameDagger).copy(testItem);
		testInventory.addItem(testItem, testNameDagger);
		String testNameSword = "Sword";
		String testItemType = Constants.objectName;
		Item testItemSword = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameSword).copy(testItemSword);
		InventoryService.addItem(testInventory, testItemSword,
				ItemCollisionAction.Stack);
		assertTrue(testInventory.getItemByName(testNameDagger).equals(testItem));
	}

	@Test
	public final void test43() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.Stack);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test44() {
		String testNameTin = "Tin";
		long testQuantity1 = 27;
		long testQuantity2 = 3;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testItem.setQuantity(testQuantity1);
		InventoryService.addItem(testInventory, testItem,
				ItemCollisionAction.Stack);
		String testItemType = Constants.objectName;
		Item testItemTin = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItemTin);
		testItemTin.setQuantity(testQuantity2);
		InventoryService.addItem(testInventory, testItemTin,
				ItemCollisionAction.Stack);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin))
				== testQuantity1 + testQuantity2);
	}

	@Test
	public final void test45() {
		String testNameTin = "Tin";
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testInventory.addItem(testItem, testNameTin);
		String testNameCopper = "Copper";
		String testItemType = Constants.objectName;
		Item testItemCopper = new Item(testItemType);
		Item.itemTemplateList.getItemByName(testNameCopper).copy(testItemCopper);
		InventoryService.addItem(testInventory, testItemCopper,
				ItemCollisionAction.Stack);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin)) == 1);
	}

	@Test
	public final void test46() {
		String testNameTin = "Tin";
		long testQuantity1 = 27;
		long testQuantity2 = 3;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testItem.setQuantity(testQuantity1);
		testInventory.addItem(testItem, testNameTin);
		InventoryService.addQuantityToItem(testInventory, testItem, testQuantity2);
		assertTrue(InventoryService.getItemQuantity(
				testInventory.getItemByName(testNameTin))
				== testQuantity1 + testQuantity2);
	}

	@Test
	public final void test47() {
		String testNameTin = "Tin";
		long testQuantity1 = 3;
		long testQuantity2 = -27;
		Item.itemTemplateList.getItemByName(testNameTin).copy(testItem);
		testItem.setQuantity(testQuantity1);
		testInventory.addItem(testItem, testNameTin);
		InventoryService.addQuantityToItem(testInventory, testItem, testQuantity2);
		assertTrue(testInventory.getItemByName(testNameTin) == null);
	}

}
