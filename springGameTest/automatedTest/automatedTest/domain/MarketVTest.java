package automatedTest.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import springGameTest.domain.MarketVO;
import springGameTest.model.User;

public class MarketVTest {
	
	private MarketVO testMarketVO = new MarketVO(new User(55));

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public final void test01() {
		assertFalse(testMarketVO.getMarketInventory() == null);
	}

	@Test
	public final void test02() {
		assertFalse(testMarketVO.getMarketItemList() == null);
	}

}
