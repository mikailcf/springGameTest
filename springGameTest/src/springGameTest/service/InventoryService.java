package springGameTest.service;

import springGameTest.Constants;
import springGameTest.domain.CraftVO;
import springGameTest.model.EntityProperties;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.model.PropertyValue;
import springGameTest.test.GameMock;

public class InventoryService {

	public static long getItemQuantity(Item item) {
		return item.getIntValue(Constants.quantity);
	}

	public static String getItemName(Item item) {
		return item.getStringValue(Constants.name);
	}

	public static long getResourcesNeeded(Item item) {
		return item.getIntValue(Constants.resourcesNeeded);
	}
	
	public static long getBuyValue(Item item, double multiplier) {
		return (long) Math.ceil(multiplier*item.getIntValue(Constants.itemValue));
	}
	
	public static long getSellValue(Item item, double multiplier) {
		return (long) Math.ceil(multiplier*item.getIntValue(Constants.itemValue)/2);
	}
	
	public static double getRandomRating(double mean) {
		double result = mean * (1 + GameMock.rand.nextGaussian()/4);
		if (result < mean/2) result = mean/2;
		return result;
	}

	public static void addItem(Inventory inventory, Item newItem, long itemQuantity) {
		Item itemCopy = newItem.copyNewId();
		PropertyService.addProperty(itemCopy.getProperties(),
				new Property(Constants.quantity, itemQuantity),
				PropertyCollisionAction.NewPrevails);
		addItem(inventory, itemCopy, ItemCollisionAction.Include);
	}

	public static void addItem(Inventory inventory, Item newItem) {
		addItem(inventory, newItem, ItemCollisionAction.Include);
	}

	public static void addItem(Inventory inventory, Item newItem, ItemCollisionAction action) {
		String itemName = newItem.getStringValue(Constants.name);
		Item currentItem = inventory.getItemByName(itemName);
		if (currentItem == null) { action = ItemCollisionAction.Include; }
		else if (action == ItemCollisionAction.Include &&
				"true".equals(currentItem.getStringValue(Constants.stackable))) {
			action = ItemCollisionAction.Stack;
		}
		switch (action) {
		case ExistingPrevails:
			break;
		case Stack:
			addItemQuantity(inventory, currentItem, newItem.getIntValue(Constants.quantity));
			break;
		case NewPrevails:
			inventory.removeById(currentItem.getItemId());
		case Include:
		default:
			inventory.addItem(newItem, itemName);
			break;
		}
		currentItem = inventory.getItemByName(itemName);
		if (getItemQuantity(currentItem) <= 0) {
			inventory.removeById(currentItem.getItemId());
		}
	}
	
	public static void addItemQuantity(Inventory inventory, Item item, long itemQuantity) {
		PropertyService.addProperty(item.getProperties(), Constants.quantity,
				new PropertyValue(itemQuantity), PropertyCollisionAction.Sum);
		if (getItemQuantity(item) <= 0) {
			inventory.removeById(item.getItemId());
		}
		
	}

	public static boolean processWorkbenchSelect(CraftVO craftVO,
			Inventory inventory, Item item) {
		long resourcesNeeded = getResourcesNeeded(item);
		Inventory availableResources = craftVO.getAvailableResources();
		
		for (Item resource: inventory.getItemList()) {
			if (resource.hasProperty(Constants.isResource) &&
					resourcesNeeded <= getItemQuantity(resource)) {
				availableResources.addItem(resource, getItemName(resource));
			}
		}
		return true;
	}

	public static boolean processCraftOrder(CraftVO craftVO,
			Inventory inventory, Item recipe, Item resource) {
		long resourcesNeeded = getResourcesNeeded(recipe);

		if (resource.hasProperty(Constants.isResource) &&
				resourcesNeeded <= getItemQuantity(resource)) {
			Item craftedItem = recipe.copyNewId();
			EntityProperties properties = craftedItem.getProperties();
			PropertyService.addProperty(properties,
					new Property(Constants.name,
							resource.getStringValue(Constants.name) + " " +
							recipe.getStringValue(Constants.name)),
					PropertyCollisionAction.NewPrevails);

			double expectedResult = 2*resourcesNeeded*
					resource.getIntValue(Constants.craftMultiplier);

			double damage = getRandomRating(expectedResult);
			double handling = getRandomRating(expectedResult);
			double durability = getRandomRating(expectedResult);
			double style = getRandomRating(expectedResult);
			double average = (damage + handling + durability + style)/4;

			PropertyService.addProperty(properties,
					new Property(Constants.itemValue,
					(long) Math.ceil(average)),
					PropertyCollisionAction.NewPrevails);
			PropertyService.addProperty(properties,
					new Property(Constants.damage, damage));
			PropertyService.addProperty(properties,
					new Property(Constants.handling, handling));
			PropertyService.addProperty(properties,
					new Property(Constants.durability, durability));
			PropertyService.addProperty(properties,
					new Property(Constants.style, style));
			PropertyService.addProperty(properties,
					new Property(Constants.overrallRating, average));
			PropertyService.addProperty(properties,
					new Property(Constants.expectedRating, expectedResult));

			
			inventory.addItem(craftedItem, getItemName(craftedItem));
			craftVO.setCraftedItem(craftedItem);

			addItemQuantity(inventory, resource, -resourcesNeeded);
			return true;
		}
		
		return false;
	}

	public static long getAbsoluteValue(Item craftedItem, String propertyName) {
		return (long) Math.ceil(craftedItem.getFloatValue(propertyName));
	}

	public static String getPercentageValue(Item craftedItem, String propertyName) {
		return ""+ (long) Math.ceil(
				100*craftedItem.getFloatValue(propertyName)/
				craftedItem.getFloatValue(Constants.expectedRating)) + "%";
	}
	
}
