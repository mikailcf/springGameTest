package automatedTest.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.Constants;
import springGameTest.domain.CraftVO;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.model.User;
import springGameTest.service.PropertyService;

public class CraftVOTest {
	
	private CraftVO testCraftVO = new CraftVO(new User(233));

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public final void test01() {
		assertFalse(testCraftVO.getAvailableResources() == null);
	}

	@Test
	public final void test02() {
		assertFalse(testCraftVO.getAvailableResourceList() == null);
	}

	@Test
	public final void test03() {
		String testName = "testName";
		Item testItem = new Item();
		PropertyService.addProperty(testItem.getProperties(),
				new Property(Constants.name, testName));
		testCraftVO.getAvailableResources().addItem(testItem, testName);
		assertTrue(testCraftVO.getAvailableResourceList().contains(testItem));
	}

	@Test
	public final void test04() {
		assertFalse(testCraftVO.getViewPage() == null);
	}

	@Test
	public final void test05() {
		String testPageName = "testPageName";
		testCraftVO.setViewPage(testPageName);
		assertTrue(testCraftVO.getViewPage().equals(testPageName));
	}

	@Test
	public final void test06() {
		Item testItem = new Item();
		testCraftVO.setSelectedRecipe(testItem);
		assertTrue(testCraftVO.getSelectedRecipe().equals(testItem));
	}

	@Test
	public final void test07() {
		Item testItem = new Item();
		testCraftVO.setCraftedItem(testItem);
		assertTrue(testCraftVO.getCraftedItem().equals(testItem));
	}

	@Test
	public final void test08() {
		String testPropertyName = "testPropertyName";
		double testFloatValue = 97.0;
		long testIntValue = (long) testFloatValue;
		double expectedValue = 100;
		Item testItem = new Item();
		PropertyService.addProperty(testItem.getProperties(),
				new Property(testPropertyName, testFloatValue));
		PropertyService.addProperty(testItem.getProperties(),
				new Property(Constants.expectedRating, expectedValue));
		testCraftVO.setCraftedItem(testItem);
		assertTrue(testCraftVO.getAbsoluteValue(testPropertyName) == testIntValue);
	}

	@Test
	public final void test09() {
		String testPropertyName = "testPropertyName";
		double testFloatValue = 97.0;
		double expectedValue = 100;
		Item testItem = new Item();
		PropertyService.addProperty(testItem.getProperties(),
				new Property(testPropertyName, testFloatValue));
		PropertyService.addProperty(testItem.getProperties(),
				new Property(Constants.expectedRating, expectedValue));
		testCraftVO.setCraftedItem(testItem);
		assertFalse(testCraftVO.getPercentageValue(testPropertyName) == null);
	}

}
