package springGameTest.domain;

import java.util.Collection;

import springGameTest.model.Item;
import springGameTest.model.Inventory;
import springGameTest.model.User;
import springGameTest.test.GameMock;

public class MarketVO extends GameVO {

	private static final Inventory marketItems = GameMock.marketItems;
	
	public MarketVO(User user) {
		super(user);
	}

	public Inventory getMarketInventory() {
		return marketItems;
	}

	public Collection<Item> getMarketItemList() {
		return marketItems.getItemList();
	}
}
