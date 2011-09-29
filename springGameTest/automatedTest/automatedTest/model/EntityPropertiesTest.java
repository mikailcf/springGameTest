package automatedTest.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.EntityProperties;
import springGameTest.model.PropertyType;
import springGameTest.model.PropertyValue;
import springGameTest.service.PropertyService;

public class EntityPropertiesTest {
	
	private EntityProperties testEntityProperties = new EntityProperties();
	private String testName1 = "testName1";
	private String testName2 = "testName2";
	private String testName3 = "testName3";
	private String testName4 = "testName4";
	private String testName5 = "testName5";
	private long testValue1 = 45;
	private double testValue2 = 37.5;
	private String testValue3 = "testValue3";
	private Date testValue4 = new Date();
	private PropertyValue testProperty1 = new PropertyValue(testValue1);
	private PropertyValue testProperty2 = new PropertyValue(testValue2);
	private PropertyValue testProperty3 = new PropertyValue(testValue3);
	private PropertyValue testProperty4 = new PropertyValue(testValue4);
	
	@Before
	public void setUp() {
		PropertyService.addProperty(testEntityProperties, testName1, testProperty1);
		PropertyService.addProperty(testEntityProperties, testName2, testProperty2);
		PropertyService.addProperty(testEntityProperties, testName3, testProperty3);
		PropertyService.addProperty(testEntityProperties, testName4, testProperty4);
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
	    assertTrue(testEntityProperties.getPropertyValueByName(testName1).
	    		equals(testProperty1));
	}

	@Test
	public final void test02() {
	    assertTrue(testEntityProperties.getPropertyValueByName(testName2).
	    		equals(testProperty2));
	}

	@Test
	public final void test03() {
	    assertTrue(testEntityProperties.getPropertyValueByName(testName3).
	    		equals(testProperty3));
	}

	@Test
	public final void test04() {
	    assertTrue(testEntityProperties.getPropertyValueByName(testName4).
	    		equals(testProperty4));
	}

	@Test
	public final void test05() {
		assertTrue(testEntityProperties.getPropertyValueByName(testName5) == null);
	}

	@Test
	public final void test06() {
	    assertTrue(testEntityProperties.getPropertyValueByNameWithDefault(testName1).
	    		equals(testProperty1));
	}

	@Test
	public final void test07() {
	    assertTrue(testEntityProperties.getPropertyValueByNameWithDefault(testName2).
	    		equals(testProperty2));
	}

	@Test
	public final void test08() {
	    assertTrue(testEntityProperties.getPropertyValueByNameWithDefault(testName3).
	    		equals(testProperty3));
	}

	@Test
	public final void test09() {
	    assertTrue(testEntityProperties.getPropertyValueByNameWithDefault(testName4).
	    		equals(testProperty4));
	}

	@Test
	public final void test10() {
		assertTrue(testEntityProperties.getPropertyValueByNameWithDefault(testName5).
	    		equals(new PropertyValue(PropertyType.Integer)));
	}

	@Test
	public final void test11() {
		EntityProperties otherEntityProperties = new EntityProperties();
		PropertyService.addProperty(otherEntityProperties, testName1, testProperty1);
		PropertyService.addProperty(otherEntityProperties, testName2, testProperty2);
		PropertyService.addProperty(otherEntityProperties, testName3, testProperty3);
		PropertyService.addProperty(otherEntityProperties, testName4, testProperty4);

		assertTrue(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test12() {
		EntityProperties otherEntityProperties = new EntityProperties();
		PropertyService.addProperty(otherEntityProperties, testName2, testProperty2);
		PropertyService.addProperty(otherEntityProperties, testName4, testProperty4);
		PropertyService.addProperty(otherEntityProperties, testName1, testProperty1);
		PropertyService.addProperty(otherEntityProperties, testName3, testProperty3);

		assertTrue(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test13() {
		EntityProperties otherEntityProperties = new EntityProperties();
		PropertyService.addProperty(otherEntityProperties, testName2, testProperty1);
		PropertyService.addProperty(otherEntityProperties, testName4, testProperty2);
		PropertyService.addProperty(otherEntityProperties, testName1, testProperty3);
		PropertyService.addProperty(otherEntityProperties, testName3, testProperty4);

		assertFalse(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test14() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyValueByName(testName1).
	    		equals(testProperty1));
	}

	@Test
	public final void test15() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyValueByName(testName2).
	    		equals(testProperty2));
	}

	@Test
	public final void test16() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyValueByName(testName3).
	    		equals(testProperty3));
	}

	@Test
	public final void test17() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyValueByName(testName4).
	    		equals(testProperty4));
	}

	@Test
	public final void test18() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
		assertTrue(testEntityProperties.keySet().
				equals(otherEntityProperties.keySet()));
	}

	@Test
	public final void test19() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
		assertTrue(testEntityProperties.size() == otherEntityProperties.size());
	}

	@Test
	public final void test20() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
		assertTrue(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test21() {
		assertTrue(testEntityProperties.hasProperty(testName1));
	}

	@Test
	public final void test22() {
		assertFalse(testEntityProperties.hasProperty(testName5));
	}

	
}
