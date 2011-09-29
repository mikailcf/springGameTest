package automatedTest.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.EntityProperties;
import springGameTest.model.Property;
import springGameTest.model.PropertyValue;
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

	@Test
	public final void test05() {
		long testValue1 = 95;
		long testValue2 = 44;
		testPropertyValue = new PropertyValue(testValue1);
		testProperties.addProperty(testName, testPropertyValue);
		PropertyService.sumProperty(testPropertyValue,
				new PropertyValue(testValue2));
		assertTrue(testPropertyValue.getIntValue() == testValue1 + testValue2);
	}

	
	
	

}
