package automatedTest.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.EntityProperties;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.model.WrongTypeException;
import springGameTest.service.PropertyService;

public class ItemTest {
	
	private long testItemId = 65;
	private Item testItem = new Item(testItemId);
	private String testName1 = "testName1";
	private String testName2 = "testName2";
	private String testName3 = "testName3";
	private String testName4 = "testName4";
	private String testName5 = "testName5";
	private long testValue1 = 21;
	private double testValue2 = 89.2;
	private String testValue3 = "testValue3";
	private Date testValue4 = new Date();
	private Property testProperty1 = new Property(testName1, testValue1);
	private Property testProperty2 = new Property(testName2, testValue2);
	private Property testProperty3 = new Property(testName3, testValue3);
	private Property testProperty4 = new Property(testName4, testValue4);
	
	@Before
	public void setUp() {
		PropertyService.addProperty(testItem.getProperties(), testProperty1);
		PropertyService.addProperty(testItem.getProperties(), testProperty2);
		PropertyService.addProperty(testItem.getProperties(), testProperty3);
		PropertyService.addProperty(testItem.getProperties(), testProperty4);
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
		assertTrue(testItem.getItemId() == testItemId);
	}

	@Test
	public final void test02() {
		assertTrue(testItem.equals(testItem));
	}

	@Test
	public final void test03() {
		assertTrue(testItem.equals(testItem.copySameId()));
	}

	@Test
	public final void test04() {
		assertFalse(testItem.equals(testItem.copyNewId()));
	}

	@Test
	public final void test05() {
		Item testOtherItem = testItem.copyNewId();
		assertTrue(testItem.getProperties().equals(testOtherItem.getProperties()));
	}

	@Test
	public final void test06() {
		Item testOtherItem = testItem.copyNewId();
		assertFalse(testItem.getItemId() == testOtherItem.getItemId());
	}

	@Test
	public final void test07() {
		EntityProperties testProperties = new EntityProperties();
		PropertyService.addProperty(testProperties, testProperty1);
		PropertyService.addProperty(testProperties, testProperty2);
		PropertyService.addProperty(testProperties, testProperty3);
		PropertyService.addProperty(testProperties, testProperty4);
		assertTrue(testItem.getProperties().equals(testProperties));
	}

	@Test
	public final void test08() {
		assertTrue(testItem.getIntValue(testName1) == testValue1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test09() {
		testItem.getIntValue(testName2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test10() {
		testItem.getIntValue(testName3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test11() {
		testItem.getIntValue(testName4);
	}

	@Test
	public final void test12() {
		assertTrue(testItem.getIntValue(testName5) == 0);
	}

	@Test (expected = WrongTypeException.class)
	public final void test13() {
		testItem.getFloatValue(testName1);
	}

	@Test
	public final void test14() {
		assertTrue(testItem.getFloatValue(testName2) == testValue2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test15() {
		testItem.getFloatValue(testName3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test16() {
		testItem.getFloatValue(testName4);
	}

	@Test (expected = WrongTypeException.class)
	public final void test17() {
		testItem.getFloatValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test18() {
		testItem.getStringValue(testName1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test19() {
		testItem.getStringValue(testName2);
	}

	@Test
	public final void test20() {
		assertTrue(testItem.getStringValue(testName3) == testValue3);
	}

	@Test (expected = WrongTypeException.class)
	public final void test21() {
		testItem.getStringValue(testName4);
	}

	@Test (expected = WrongTypeException.class)
	public final void test22() {
		testItem.getStringValue(testName5);
	}

	@Test (expected = WrongTypeException.class)
	public final void test23() {
		testItem.getDateValue(testName1);
	}

	@Test (expected = WrongTypeException.class)
	public final void test24() {
		testItem.getDateValue(testName2);
	}

	@Test (expected = WrongTypeException.class)
	public final void test25() {
		testItem.getDateValue(testName3);
	}

	@Test
	public final void test26() {
		assertTrue(testItem.getDateValue(testName4) == testValue4);
	}

	@Test (expected = WrongTypeException.class)
	public final void test27() {
		testItem.getDateValue(testName5);
	}

	@Test
	public final void test28() {
		assertTrue(testItem.hasProperty(testName1));
	}

	@Test
	public final void test29() {
		assertFalse(testItem.hasProperty(testName5));
	}

}
