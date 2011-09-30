package automatedTest.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.EntityProperties;
import springGameTest.model.PropertyValue;
import springGameTest.model.WrongTypeException;
import springGameTest.service.PropertyCollisionAction;
import springGameTest.service.PropertyService;

public class PropertyServiceTest {

	private String testName = "testName";
	private PropertyValue testPropertyValue;
	private EntityProperties testProperties = new EntityProperties();
	
	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public final void test01() {
		long testValue1 = 95;
		long testValue2 = 44;
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
		assertTrue(testPropertyValue.getIntValue() == testValue1 + testValue2);
	}

	@Test
	public final void test02() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
		assertTrue(testPropertyValue.getFloatValue() == testValue1 + testValue2);
	}

	@Test
	public final void test03() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
		assertTrue(testPropertyValue.getStringValue().contains(testValue1));
	}

	@Test
	public final void test04() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
		assertTrue(testPropertyValue.getStringValue().contains(testValue2));
	}

	@Test (expected = WrongTypeException.class)
	public final void test05() {
		long testValue1 = 95;
		double testValue2 = 24.7;
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
	}

	@Test (expected = WrongTypeException.class)
	public final void test06() {
		long testValue1 = 95;
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
	}

	@Test (expected = WrongTypeException.class)
	public final void test07() {
		long testValue1 = 95;
		Date testValue2 = new Date();
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
	}

	@Test (expected = WrongTypeException.class)
	public final void test08() {
		double testValue1 = 63.3;
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
	}

	@Test (expected = WrongTypeException.class)
	public final void test09() {
		double testValue1 = 63.3;
		Date testValue2 = new Date();
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
	}

	@Test (expected = WrongTypeException.class)
	public final void test10() {
		String testValue1 = "bnm";
		Date testValue2 = new Date();
		testPropertyValue = new PropertyValue(testValue1);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
	}

	@Test
	public final void test11() {
		long testValue1 = 95;
		long testValue2 = 44;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testPropertyValue.getIntValue() == testValue1);
	}

	@Test
	public final void test12() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getFloatValue() == testValue1);
	}

	@Test
	public final void test13() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getStringValue().equals(testValue1));
	}

	@Test
	public final void test14() {
		Date testValue1 = new Date();
		Date testValue2 = new Date();
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getDateValue() == testValue1);
	}

	@Test
	public final void test15() {
		long testValue1 = 95;
		long testValue2 = 44;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getIntValue() == testValue2);
	}

	@Test
	public final void test16() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getFloatValue() == testValue2);
	}

	@Test
	public final void test17() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getStringValue().equals(testValue2));
	}

	@Test
	public final void test18() {
		Date testValue1 = new Date();
		Date testValue2 = new Date();
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getDateValue() == testValue2);
	}

	@Test
	public final void test19() {
		long testValue1 = 95;
		long testValue2 = 44;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getIntValue() == testValue1 + testValue2);
	}

	@Test
	public final void test20() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getFloatValue() == testValue1 + testValue2);
	}

	@Test
	public final void test21() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getStringValue().contains(testValue1));
	}

	@Test
	public final void test22() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getStringValue().contains(testValue2));
	}

	@Test
	public final void test23() {
		Date testValue1 = new Date();
		Date testValue2 = new Date();
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getDateValue() == testValue1);
	}

	@Test
	public final void test24() {
		long testValue1 = 95;
		long testValue2 = 44;
		long testOtherValue = 79;
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getIntValue() == testOtherValue);
	}

	@Test
	public final void test25() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		double testOtherValue = 79.4;
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getFloatValue() == testOtherValue);
	}

	@Test
	public final void test26() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		String testOtherValue = "testOtherValue";
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getStringValue() == testOtherValue);
	}

	@Test
	public final void test27() {
		Date testValue1 = new Date();
		Date testValue2 = new Date();
		Date testOtherValue = new Date();
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.ExistingPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getDateValue() == testOtherValue);
	}

	@Test
	public final void test28() {
		long testValue1 = 95;
		long testValue2 = 44;
		long testOtherValue = 79;
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getIntValue() == testOtherValue);
	}

	@Test
	public final void test29() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		double testOtherValue = 79.4;
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getFloatValue() == testOtherValue);
	}

	@Test
	public final void test30() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		String testOtherValue = "testOtherValue";
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getStringValue() == testOtherValue);
	}

	@Test
	public final void test31() {
		Date testValue1 = new Date();
		Date testValue2 = new Date();
		Date testOtherValue = new Date();
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.NewPrevails);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getDateValue() == testOtherValue);
	}

	@Test
	public final void test32() {
		long testValue1 = 95;
		long testValue2 = 44;
		long testOtherValue = 79;
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getIntValue() == testOtherValue);
	}

	@Test
	public final void test33() {
		double testValue1 = 63.3;
		double testValue2 = 24.7;
		double testOtherValue = 79.4;
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getFloatValue() == testOtherValue);
	}

	@Test
	public final void test34() {
		String testValue1 = "bnm";
		String testValue2 = "cxz";
		String testOtherValue = "testOtherValue";
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testOtherName).
				getStringValue() == testOtherValue);
	}

	@Test
	public final void test35() {
		Date testValue1 = new Date();
		Date testValue2 = new Date();
		Date testOtherValue = new Date();
		String testOtherName = "testOtherName";
		testProperties.addProperty(testOtherName,
				new PropertyValue(testOtherValue));
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.addProperty(testProperties, testName,
				new PropertyValue(testValue2),
				PropertyCollisionAction.Sum);
		assertTrue(testProperties.getPropertyValueByName(testName)
				.getDateValue() == testValue1);
	}

}
