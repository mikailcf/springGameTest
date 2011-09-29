package springGameTest.test;

import java.util.Random;

import springGameTest.Constants;
import springGameTest.model.Item;
import springGameTest.model.Inventory;
import springGameTest.model.ItemTemplate;
import springGameTest.model.Property;
import springGameTest.model.User;
import springGameTest.service.InventoryService;
import springGameTest.service.PropertyService;

public class GameMock {

	public static User user = new User(1);
	public static final Inventory marketItems = initializeGame();//MarketItems();
	public static final Random rand = new Random();
	
	private static Inventory initializeGame() {
		Inventory itemTemplate = initializeItemTemplate();
		initializeUser(itemTemplate);
		return initializeMarketItems(itemTemplate);
	}
		
	private static Inventory initializeMarketItems(Inventory itemTemplate) {
		Inventory inventory = new Inventory();

		InventoryService.addItem(inventory, itemTemplate.getItemByName("Tin"), 1);
		InventoryService.addItem(inventory, itemTemplate.getItemByName("Copper"), 1);
		InventoryService.addItem(inventory, itemTemplate.getItemByName("Iron"), 1);
		InventoryService.addItem(inventory, itemTemplate.getItemByName("Steel"), 1);
		InventoryService.addItem(inventory, itemTemplate.getItemByName("Titanium"), 1);
		InventoryService.addItem(inventory, itemTemplate.getItemByName("Mithril"), 1);
		
		return inventory;
	}

	private static void initializeUser(Inventory itemTemplate) {
		//Initializing the user for testing purposes
		PropertyService.addProperty(user.getProperties(), new Property(Constants.name, "Smith"));
		PropertyService.addProperty(user.getProperties(), new Property(Constants.userMoney, 1000));
		PropertyService.addProperty(user.getProperties(), new Property(Constants.currentEnergy, 100));
		PropertyService.addProperty(user.getProperties(), new Property(Constants.maximumEnergy, 100));

		InventoryService.addItem(user.getInventory(), itemTemplate.getItemByName("Tin"), 10);

		InventoryService.addItem(user.getRecipes(), itemTemplate.getItemByName("Dagger"), 1);
		InventoryService.addItem(user.getRecipes(), itemTemplate.getItemByName("Sword"), 1);
	}

	private static Inventory initializeItemTemplate() {
		Inventory itemTemplate = ItemTemplate.itemList;

		Item tin = new Item();
		PropertyService.addProperty(tin.getProperties(), new Property(Constants.name, "Tin"));
		PropertyService.addProperty(tin.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(tin.getProperties(), new Property(Constants.itemValue, 10));
		PropertyService.addProperty(tin.getProperties(), new Property(Constants.craftMultiplier, 11));
		PropertyService.addProperty(tin.getProperties(), new Property(Constants.stackable, "true"));
		PropertyService.addProperty(tin.getProperties(), new Property(Constants.isResource, "true"));
		InventoryService.addItem(itemTemplate, tin);

		Item copper = new Item();
		PropertyService.addProperty(copper.getProperties(), new Property(Constants.name, "Copper"));
		PropertyService.addProperty(copper.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(copper.getProperties(), new Property(Constants.itemValue, 20));
		PropertyService.addProperty(copper.getProperties(), new Property(Constants.craftMultiplier, 23));
		PropertyService.addProperty(copper.getProperties(), new Property(Constants.stackable, "true"));
		PropertyService.addProperty(copper.getProperties(), new Property(Constants.isResource, "true"));
		InventoryService.addItem(itemTemplate, copper);
		
		Item iron = new Item();
		PropertyService.addProperty(iron.getProperties(), new Property(Constants.name, "Iron"));
		PropertyService.addProperty(iron.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(iron.getProperties(), new Property(Constants.itemValue, 50));
		PropertyService.addProperty(iron.getProperties(), new Property(Constants.craftMultiplier, 54));
		PropertyService.addProperty(iron.getProperties(), new Property(Constants.stackable, "true"));
		PropertyService.addProperty(iron.getProperties(), new Property(Constants.isResource, "true"));
		InventoryService.addItem(itemTemplate, iron);
		
		Item steel = new Item();
		PropertyService.addProperty(steel.getProperties(), new Property(Constants.name, "Steel"));
		PropertyService.addProperty(steel.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(steel.getProperties(), new Property(Constants.itemValue, 200));
		PropertyService.addProperty(steel.getProperties(), new Property(Constants.craftMultiplier, 205));
		PropertyService.addProperty(steel.getProperties(), new Property(Constants.stackable, "true"));
		PropertyService.addProperty(steel.getProperties(), new Property(Constants.isResource, "true"));
		InventoryService.addItem(itemTemplate, steel);
		
		Item titanium = new Item();
		PropertyService.addProperty(titanium.getProperties(), new Property(Constants.name, "Titanium"));
		PropertyService.addProperty(titanium.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(titanium.getProperties(), new Property(Constants.itemValue, 1000));
		PropertyService.addProperty(titanium.getProperties(), new Property(Constants.craftMultiplier, 1006));
		PropertyService.addProperty(titanium.getProperties(), new Property(Constants.stackable, "true"));
		PropertyService.addProperty(titanium.getProperties(), new Property(Constants.isResource, "true"));
		InventoryService.addItem(itemTemplate, titanium);
		
		Item mithril = new Item();
		PropertyService.addProperty(mithril.getProperties(), new Property(Constants.name, "Mithril"));
		PropertyService.addProperty(mithril.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(mithril.getProperties(), new Property(Constants.itemValue, 10000));
		PropertyService.addProperty(mithril.getProperties(), new Property(Constants.craftMultiplier, 10007));
		PropertyService.addProperty(mithril.getProperties(), new Property(Constants.stackable, "true"));
		PropertyService.addProperty(mithril.getProperties(), new Property(Constants.isResource, "true"));
		InventoryService.addItem(itemTemplate, mithril);
		
		Item dagger = new Item();
		PropertyService.addProperty(dagger.getProperties(), new Property(Constants.name, "Dagger"));
		PropertyService.addProperty(dagger.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(dagger.getProperties(), new Property(Constants.itemValue, 1));
		PropertyService.addProperty(dagger.getProperties(), new Property(Constants.resourcesNeeded, 3));
		InventoryService.addItem(itemTemplate, dagger);
		
		Item sword = new Item();
		PropertyService.addProperty(sword.getProperties(), new Property(Constants.name, "Sword"));
		PropertyService.addProperty(sword.getProperties(), new Property(Constants.quantity, 1));
		PropertyService.addProperty(sword.getProperties(), new Property(Constants.itemValue, 1));
		PropertyService.addProperty(sword.getProperties(), new Property(Constants.resourcesNeeded, 12));
		InventoryService.addItem(itemTemplate, sword);
		return itemTemplate;
	}
	
}
