package automatedTest.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.EntityProperties;
import springGameTest.model.PropertyType;
import springGameTest.model.Property;
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
	private Property testProperty1 = new Property(testName1, testValue1);
	private Property testProperty2 = new Property(testName2, testValue2);
	private Property testProperty3 = new Property(testName3, testValue3);
	private Property testProperty4 = new Property(testName4, testValue4);
	
	@Before
	public void setUp() {
		PropertyService.addProperty(testEntityProperties, testProperty1);
		PropertyService.addProperty(testEntityProperties, testProperty2);
		PropertyService.addProperty(testEntityProperties, testProperty3);
		PropertyService.addProperty(testEntityProperties, testProperty4);
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
	    assertTrue(testEntityProperties.getPropertyByName(testName1).
	    		equals(testProperty1));
	}

	@Test
	public final void test02() {
	    assertTrue(testEntityProperties.getPropertyByName(testName2).
	    		equals(testProperty2));
	}

	@Test
	public final void test03() {
	    assertTrue(testEntityProperties.getPropertyByName(testName3).
	    		equals(testProperty3));
	}

	@Test
	public final void test04() {
	    assertTrue(testEntityProperties.getPropertyByName(testName4).
	    		equals(testProperty4));
	}

	@Test
	public final void test05() {
		assertTrue(testEntityProperties.getPropertyByName(testName5) == null);
	}

	@Test
	public final void test06() {
	    assertTrue(testEntityProperties.getPropertyByNameWithDefault(testName1).
	    		equals(testProperty1));
	}

	@Test
	public final void test07() {
	    assertTrue(testEntityProperties.getPropertyByNameWithDefault(testName2).
	    		equals(testProperty2));
	}

	@Test
	public final void test08() {
	    assertTrue(testEntityProperties.getPropertyByNameWithDefault(testName3).
	    		equals(testProperty3));
	}

	@Test
	public final void test09() {
	    assertTrue(testEntityProperties.getPropertyByNameWithDefault(testName4).
	    		equals(testProperty4));
	}

	@Test
	public final void test10() {
		assertTrue(testEntityProperties.getPropertyByNameWithDefault(testName5).
	    		equals(new Property(testName5, PropertyType.Integer)));
	}

	@Test
	public final void test11() {
		EntityProperties otherEntityProperties = new EntityProperties();
		PropertyService.addProperty(otherEntityProperties, testProperty1);
		PropertyService.addProperty(otherEntityProperties, testProperty2);
		PropertyService.addProperty(otherEntityProperties, testProperty3);
		PropertyService.addProperty(otherEntityProperties, testProperty4);

		assertTrue(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test12() {
		EntityProperties otherEntityProperties = new EntityProperties();
		PropertyService.addProperty(otherEntityProperties, testProperty2);
		PropertyService.addProperty(otherEntityProperties, testProperty4);
		PropertyService.addProperty(otherEntityProperties, testProperty1);
		PropertyService.addProperty(otherEntityProperties, testProperty3);

		assertTrue(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test13() {
		EntityProperties otherEntityProperties = new EntityProperties();
		PropertyService.addProperty(otherEntityProperties, testProperty1);
		PropertyService.addProperty(otherEntityProperties, testProperty2);
		PropertyService.addProperty(otherEntityProperties, testProperty3);
		PropertyService.addProperty(otherEntityProperties, testProperty4);

		assertFalse(testEntityProperties.equals(otherEntityProperties));
	}

	@Test
	public final void test14() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyByName(testName1).
	    		equals(testProperty1));
	}

	@Test
	public final void test15() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyByName(testName2).
	    		equals(testProperty2));
	}

	@Test
	public final void test16() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyByName(testName3).
	    		equals(testProperty3));
	}

	@Test
	public final void test17() {
		EntityProperties otherEntityProperties = new EntityProperties();
		testEntityProperties.copy(otherEntityProperties);
	    assertTrue(otherEntityProperties.getPropertyByName(testName4).
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
