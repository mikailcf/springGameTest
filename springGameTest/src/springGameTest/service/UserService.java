package springGameTest.service;

import springGameTest.domain.CraftVO;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.Recipe;
import springGameTest.model.User;

public class UserService {
	
	public static long getBuyValue(User user, Item item) {
		return InventoryService.getBuyValue(item, 1.0);
	}
	
	public static long getSellValue(User user, Item item) {
		return InventoryService.getSellValue(item, 1.0);
	}
	
	public static void processBuyOrder(User user, Inventory inventory,
			String stringItemId, String buyingQuantity) {
		Integer itemId;
		try {
			itemId = new Integer(stringItemId);
		} catch (Exception e) {
			EventService.addEventToUser(user, "Item not found");
			return;
		}
		
		Item item = inventory.getItemById(itemId);
		if (item == null) {
			EventService.addEventToUser(user, "Item not found");
			return;
		}
		
		processBuyOrder(user, item, buyingQuantity);
	}

	// ToDo: include logic to validate item quantity
	public static void processBuyOrder(User user, Item item, String stringBuyingQuantity) {
		long buyingQuantity;
		try {
			buyingQuantity = new Integer(stringBuyingQuantity).longValue();
		} catch (Exception e) {
			EventService.addEventToUser(user, "" +
					stringBuyingQuantity +" is not a valid number");
			return;
		}

		long orderValue = buyingQuantity * getBuyValue(user, item);
		if (orderValue <= user.getMoney()) {
			user.setMoney(user.getMoney() - orderValue);
			InventoryService.addItem(user.getInventory(), item, buyingQuantity);
			EventService.addEventToUser(user, "" + buyingQuantity + "x " +
					InventoryService.getItemName(item) + " bought for $" + orderValue);
		}
		else {
			EventService.addEventToUser(user, "Not enought money");
		}
		
	}
	
	public static void processSellOrder(User user, Inventory inventory,
			String stringItemId) {
		processSellOrder(user, inventory, stringItemId, "1");
	}
	
	public static void processSellOrder(User user, Inventory inventory,
			String stringItemId, String sellingQuantity) {
		Integer itemId;
		try {
			itemId = new Integer(stringItemId);
		} catch (Exception e) {
			EventService.addEventToUser(user, "Item not found");
			return;
		}
		
		Item item = inventory.getItemById(itemId);
		if (item == null) {
			EventService.addEventToUser(user, "Item not found");
			return;
		}
		
		processSellOrder(user, item, sellingQuantity);
	}

	// ToDo: include logic to validate item quantity
	public static void processSellOrder(User user, Item item, String stringSellingQuantity) {
		long sellingQuantity;
		try {
			sellingQuantity = new Integer(stringSellingQuantity).longValue();
		} catch (Exception e) {
			EventService.addEventToUser(user, "" +
					stringSellingQuantity + " is not a valid number");
			return;
		}

		long orderValue = sellingQuantity * getSellValue(user, item);
		if (sellingQuantity <= InventoryService.getItemQuantity(item)) {
			user.setMoney(user.getMoney() + orderValue);
			InventoryService.addQuantityToItem(user.getInventory(), item, -sellingQuantity);
			EventService.addEventToUser(user, "" + sellingQuantity + "x " +
					InventoryService.getItemName(item) + " sold for $" + orderValue);
		}
		else {
			EventService.addEventToUser(user, "Not enought quantity");
		}
		
	}

	public static boolean processWorkbenchSelect(CraftVO craftVO, String stringRecipeId) {
		User user = craftVO.getUser();
		Integer recipeId;
		try {
			recipeId = new Integer(stringRecipeId);
		} catch (Exception e) {
			EventService.addEventToUser(user, "Recipe not found");
			return false;
		}
		
		Recipe recipe = user.getRecipes().getRecipe(recipeId);
		if (recipe == null) {
			EventService.addEventToUser(user, "Recipe not found");
			return false;
		}

		craftVO.setSelectedRecipe(recipe);
		
		return InventoryService.processWorkbenchSelect(craftVO, user.getInventory(), recipe);
	}

	public static boolean processCraftOrder(CraftVO craftVO, String stringRecipeId,
			String stringResourceId) {
		User user = craftVO.getUser();
		Integer recipeId;
		try {
			recipeId = new Integer(stringRecipeId);
		} catch (Exception e) {
			EventService.addEventToUser(user, "Recipe not found");
			return false;
		}

		Recipe recipe = user.getRecipes().getRecipe(recipeId);
		if (recipe == null) {
			EventService.addEventToUser(user, "Recipe not found");
			return false;
		}

		Integer resourceId;
		try {
			resourceId = new Integer(stringResourceId);
		} catch (Exception e) {
			EventService.addEventToUser(user, "Resource not found");
			return false;
		}
		
		Item resource = user.getInventory().getItemById(resourceId);
		if (resource == null) {
			EventService.addEventToUser(user, "Resource not found");
			return false;
		}
		
		long energyNeeded = InventoryService.getResourcesNeeded(recipe);
		if (user.getEnergy() < energyNeeded) {
			EventService.addEventToUser(user, "Not enough energy");
			return false;
		}
		user.setEnergy(user.getEnergy() - energyNeeded);
		
		if(InventoryService.processCraftOrder(craftVO, user.getInventory(),
				recipe, resource, user.getSkills())) {
			Item craftedItem = craftVO.getCraftedItem();
			EventService.addEventToUser(user, "Crafted one " + 
					InventoryService.getItemName(craftedItem) + " worth of $" + 
					getSellValue(user, craftedItem));
			return true;
		}
		return false;
	}

	public static void addRecipe(User user, Recipe recipe) {
		user.getRecipes().addRecipe(recipe);
		SkillService.grantSkillToUser(user, recipe.getSkill());
	}

}
