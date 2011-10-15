package automatedTest.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.model.Property;
import springGameTest.model.PropertyType;

public class PropertyTest {
	
	private Property testProperty;
	
	@Before
	public void setUp() {
	}
	
	@After
	public void close() {
		
	}

	@Test
	public final void test01() {
		String name = "testName";
		PropertyType type = PropertyType.Integer;
		testProperty = new Property(name, type);
	    assertTrue(name.equals(testProperty.getPropertyName()));
	}

	@Test
	public final void test02() {
		String name = "testName";
		PropertyType type = PropertyType.Integer;
		testProperty = new Property(name, type);
		assertTrue(type == testProperty.getValueType());
	}

	@Test
	public final void test03() {
		String name = "testName";
		long value = 27;
		testProperty = new Property(name, value);
	    assertTrue(name.equals(testProperty.getPropertyName()));
	}

	@Test
	public final void test04() {
		String name = "testName";
		long value = 27;
		testProperty = new Property(name, value);
	    assertTrue(value == testProperty.getIntValue());
	}

	@Test
	public final void test05() {
		String name = "testName";
		double value = 27.0;
		testProperty = new Property(name, value);
	    assertTrue(name.equals(testProperty.getPropertyName()));
	}

	@Test
	public final void test06() {
		String name = "testName";
		double value = 27.0;
		testProperty = new Property(name, value);
	    assertTrue(value == testProperty.getFloatValue());
	}

	@Test
	public final void test07() {
		String name = "testName";
		String value = "testValue";
		testProperty = new Property(name, value);
	    assertTrue(name.equals(testProperty.getPropertyName()));
	}

	@Test
	public final void test08() {
		String name = "testName";
		String value = "testValue";
		testProperty = new Property(name, value);
	    assertTrue(value.equals(testProperty.getStringValue()));
	}

	@Test
	public final void test09() {
		String name = "testName";
		String value = "testValue";
		testProperty = new Property(name, value);
	    assertTrue(name.equals(testProperty.getPropertyName()));
	}

	@Test
	public final void test10() {
		String name = "testName";
		Date value = new Date();
		testProperty = new Property(name, value);
	    assertTrue(value.equals(testProperty.getDateValue()));
	}

	@Test
	public final void test11() {
		String name = "testName";
		long value = 27;
		testProperty = new Property(name, value);
	    assertTrue(testProperty.equals(testProperty));
	}

	@Test
	public final void test12() {
		String name = "testName";
		long value = 27;
		testProperty = new Property(name, value);
	    assertTrue(testProperty.equals(new Property(name, value)));
	}

}
