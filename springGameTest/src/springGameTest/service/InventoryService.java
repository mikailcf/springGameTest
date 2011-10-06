package springGameTest.service;

import springGameTest.Constants;
import springGameTest.domain.CraftVO;
import springGameTest.model.EntityProperties;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.Property;
import springGameTest.test.GameMock;

public class InventoryService {

	public static long getItemQuantity(Item item) {
		return item.getQuantity();
	}

	public static String getItemName(Item item) {
		return item.getName();
	}

	public static long getResourcesNeeded(Item item) {
		return item.getIntValue(Constants.resourcesNeeded);
	}
	
	public static long getBuyValue(Item item, double multiplier) {
		return (long) Math.ceil(multiplier*item.getValue());
	}
	
	public static long getSellValue(Item item, double multiplier) {
		return (long) Math.ceil(multiplier*item.getValue()/2);
	}
	
	public static double getRandomRating(double mean) {
		double result = mean * (1 + GameMock.rand.nextGaussian()/4);
		if (result < mean/2) result = mean/2;
		return result;
	}

	public static long getAbsoluteValue(Item craftedItem, String propertyName) {
		return (long) Math.ceil(craftedItem.getFloatValue(propertyName));
	}

	public static String getPercentageValue(Item craftedItem, String propertyName) {
		double dividend = craftedItem.getFloatValue(propertyName);
		double divisor = craftedItem.getFloatValue(Constants.expectedRating);
		divisor = divisor == 0 ? (dividend == 0 ? 1 : dividend) : divisor;
		return ""+ (long) Math.ceil(100*dividend/divisor) + "%";
	}

	public static void addItem(Inventory inventory, Item newItem, long itemQuantity) {
		Item itemCopy = newItem.copyNewId();
		itemCopy.setQuantity(itemQuantity);
		addItem(inventory, itemCopy, ItemCollisionAction.Include);
	}

	public static void addItem(Inventory inventory, Item newItem) {
		addItem(inventory, newItem, ItemCollisionAction.Include);
	}

	public static void addItem(Inventory inventory, Item newItem, ItemCollisionAction action) {
		String itemName = getItemName(newItem);
		Item currentItem = inventory.getItemByName(itemName);
		if (currentItem == null) { action = ItemCollisionAction.Include; }
		else if (action == ItemCollisionAction.Include &&
				currentItem.isTypeOrSubType(Constants.stackableName)) {
			action = ItemCollisionAction.Stack;
		}
		switch (action) {
		case ExistingPrevails:
			break;
		case Stack:
			addQuantityToItem(inventory, currentItem, getItemQuantity(newItem));
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
	
	public static void addQuantityToItem(Inventory inventory, Item item, long itemQuantity) {
		item.setQuantity(item.getQuantity() + itemQuantity) ;
		if (getItemQuantity(item) <= 0) {
			inventory.removeById(item.getItemId());
		}
		
	}

	public static boolean processWorkbenchSelect(CraftVO craftVO,
			Inventory inventory, Item item) {
		long resourcesNeeded = getResourcesNeeded(item);
		Inventory availableResources = craftVO.getAvailableResources();
		
		for (Item resource: inventory.getItemList()) {
			if (resource.isTypeOrSubType(Constants.resourceName) &&
					resourcesNeeded <= getItemQuantity(resource)) {
				availableResources.addItem(resource, getItemName(resource));
			}
		}
		return true;
	}

	public static boolean processCraftOrder(CraftVO craftVO,
			Inventory inventory, Item recipe, Item resource) {
		long resourcesNeeded = getResourcesNeeded(recipe);

		if (resource.isTypeOrSubType(Constants.resourceName) &&
				resourcesNeeded <= getItemQuantity(resource)) {
			Item craftedItem = recipe.copyNewId();
			EntityProperties properties = craftedItem.getProperties();
			craftedItem.setName(resource.getName() + " " + recipe.getName());

			double expectedResult = 2*resourcesNeeded*
					resource.getIntValue(Constants.craftMultiplier);

			double damage = getRandomRating(expectedResult);
			double handling = getRandomRating(expectedResult);
			double durability = getRandomRating(expectedResult);
			double style = getRandomRating(expectedResult);
			double average = (damage + handling + durability + style)/4;

			craftedItem.setValue((long) Math.ceil(average));
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

			addQuantityToItem(inventory, resource, -resourcesNeeded);
			return true;
		}
		
		return false;
	}
	
}
