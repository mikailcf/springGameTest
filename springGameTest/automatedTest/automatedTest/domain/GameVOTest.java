package automatedTest.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.Constants;
import springGameTest.domain.GameVO;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.model.User;
import springGameTest.model.WrongTypeException;
import springGameTest.service.InventoryService;
import springGameTest.service.PropertyService;

public class GameVOTest {

	
	private long testUserId = 12;
	private User testUser = new User(testUserId, "testName");

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
	private GameVO testGameVO;
	
	@Before
	public void setUp() {
		PropertyService.addProperty(testUser.getProperties(), testProperty1);
		PropertyService.addProperty(testUser.getProperties(), testProperty2);
		PropertyService.addProperty(testUser.getProperties(), testProperty3);
		PropertyService.addProperty(testUser.getProperties(), testProperty4);
		testGameVO = new GameVO(testUser);
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
		assertTrue(testGameVO.getUser() == testUser);
	}

	@Test
	public final void test02() {
		assertTrue(testGameVO.getProperties() == testUser.getProperties());
	}

	@Test
	public final void test03() {
		assertTrue(testGameVO.getInventory() == testUser.getInventory());
	}

	@Test
	public final void test04() {
		assertTrue(testGameVO.getRecipes() == testUser.getRecipes());
	}

	@Test
	public final void test05() {
		assertTrue(testGameVO.getIntValue(testName1) == testValue1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test06() {
		testGameVO.getIntValue(testName2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test07() {
		testGameVO.getIntValue(testName3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test08() {
		testGameVO.getIntValue(testName4);
	}

	@Test (expected = NullPointerException.class)
	public final void test09() {
		testGameVO.getIntValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test10() {
		testGameVO.getFloatValue(testName1);
	}

	@Test
	public final void test11() {
		assertTrue(testGameVO.getFloatValue(testName2) == testValue2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test12() {
		testGameVO.getFloatValue(testName3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test13() {
		testGameVO.getFloatValue(testName4);
	}

	@Test (expected = NullPointerException.class)
	public final void test14() {
		testGameVO.getFloatValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test15() {
		testGameVO.getStringValue(testName1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test16() {
		testGameVO.getStringValue(testName2);
	}

	@Test
	public final void test17() {
		assertTrue(testGameVO.getStringValue(testName3) == testValue3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test18() {
		testGameVO.getStringValue(testName4);
	}

	@Test (expected = NullPointerException.class)
	public final void test19() {
		testGameVO.getStringValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test20() {
		testGameVO.getDateValue(testName1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test21() {
		testGameVO.getDateValue(testName2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test22() {
		testGameVO.getDateValue(testName3);
	}

	@Test
	public final void test23() {
		assertTrue(testGameVO.getDateValue(testName4) == testValue4);
	}

	@Test (expected = NullPointerException.class)
	public final void test24() {
		testGameVO.getDateValue(testName5);
	}

	@Test
	public final void test25() {
		String testItemType = Constants.objectName;
		Item testItem1 = new Item(testItemType);
		Item testItem2 = new Item(testItemType);
		testItem1.setName(testName1);
		testItem2.setName(testName2);
		testUser.getInventory().addItem(testItem1, InventoryService.getItemName(testItem1));
		testUser.getInventory().addItem(testItem2, InventoryService.getItemName(testItem2));
		assertTrue(testGameVO.getItemList().contains(testItem1));
	}

	@Test
	public final void test27() {
		String testItemType = Constants.objectName;
		Item testItem1 = new Item(testItemType);
		Item testItem2 = new Item(testItemType);
		Item testItem3 = new Item(testItemType);
		testItem1.setName(testName1);
		testItem2.setName(testName2);
		testItem3.setName(testName3);
		InventoryService.addItem(testUser.getInventory(), testItem1);
		InventoryService.addItem(testUser.getInventory(), testItem2);
		assertFalse(testGameVO.getItemList().contains(testItem3));
	}

}
