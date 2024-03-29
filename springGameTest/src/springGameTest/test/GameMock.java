package springGameTest.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

import springGameTest.Constants;
import springGameTest.model.EntityProperties;
import springGameTest.model.Item;
import springGameTest.model.Inventory;
import springGameTest.model.ItemType;
import springGameTest.model.Property;
import springGameTest.model.Recipe;
import springGameTest.model.Skill;
import springGameTest.model.User;
import springGameTest.service.InventoryService;
import springGameTest.service.PropertyService;
import springGameTest.service.UserService;

public class GameMock {

	public static User user;
	public static final Inventory marketItems = initializeGame();//MarketItems();
	public static final Random rand = new Random();
	
	private static Inventory initializeGame() {
		initializeItemTypeHierarchy();
		initializeSkillTypeHierarchy();
		initializeRecipes();
		Inventory itemTemplate = initializeItemTemplate();
		initializeUser(itemTemplate);
		return initializeMarketItems(itemTemplate);
	}

	private static Inventory initializeMarketItems(Inventory itemTemplate) {
		Inventory inventory = new Inventory();

		inventory.addItem(itemTemplate.getItemByName(Constants.tinName));
		inventory.addItem(itemTemplate.getItemByName(Constants.copperName));
		inventory.addItem(itemTemplate.getItemByName(Constants.ironName));
		inventory.addItem(itemTemplate.getItemByName(Constants.steelName));
		inventory.addItem(itemTemplate.getItemByName(Constants.titaniumName));
		inventory.addItem(itemTemplate.getItemByName(Constants.mithrilName));
		
		return inventory;
	}

	private static void initializeUser(Inventory itemTemplate) {
		//Initializing the user for testing purposes
		user = new User(1, "Smith");
		user.setEnergy(100);
		user.setMaxEnergy(100);
		user.setMoney(1000000);

		InventoryService.addItem(user.getInventory(),
				itemTemplate.getItemByName(Constants.tinName), 10);

		UserService.addRecipe(user, Recipe.getRecipe(Constants.daggerName));
		UserService.addRecipe(user, Recipe.getRecipe(Constants.swordName));
	}

	private static Inventory initializeItemTemplate() {
		Inventory itemTemplate = Item.itemTemplateList;

		Item tin = new Item(Constants.tinName);
		tin.setValue(10);
		InventoryService.addItem(itemTemplate, tin);

		Item copper = new Item(Constants.copperName);
		copper.setValue(20);
		InventoryService.addItem(itemTemplate, copper);
		
		Item iron = new Item(Constants.ironName);
		iron.setValue(50);
		InventoryService.addItem(itemTemplate, iron);
		
		Item steel = new Item(Constants.steelName);
		steel.setValue(200);
		InventoryService.addItem(itemTemplate, steel);
		
		Item titanium = new Item(Constants.titaniumName);
		titanium.setValue(1000);
		InventoryService.addItem(itemTemplate, titanium);
		
		Item mithril = new Item(Constants.mithrilName);
		mithril.setValue(10000);
		InventoryService.addItem(itemTemplate, mithril);
		
		Item dagger = new Item(Constants.daggerName);
		dagger.setValue(1);
		InventoryService.addItem(itemTemplate, dagger);
		
		Item sword = new Item(Constants.swordName);
		sword.setValue(1);
		InventoryService.addItem(itemTemplate, sword);
		
		return itemTemplate;
	}
	
	public static void initializeItemTypeHierarchy () {
		
		ItemType itemType = new ItemType(Constants.objectName);
		
		itemType = new ItemType(Constants.stackableName);
		itemType.getParentTypes().add(Constants.objectName);
		
		itemType = new ItemType(Constants.resourceName);
		itemType.getParentTypes().add(Constants.objectName);
		
		itemType = new ItemType(Constants.metalName);
		itemType.getParentTypes().add(Constants.resourceName);
		itemType.getParentTypes().add(Constants.stackableName);
		
		itemType = new ItemType(Constants.weaponName);
		itemType.getParentTypes().add(Constants.objectName);
		
		itemType = new ItemType(Constants.meeleWeaponName);
		itemType.getParentTypes().add(Constants.weaponName);

		itemType = new ItemType(Constants.tinName);
		itemType.getParentTypes().add(Constants.metalName);
		PropertyService.addProperty(itemType.getProperties(), new Property(Constants.craftMultiplier, 10));

		itemType = new ItemType(Constants.copperName);
		itemType.getParentTypes().add(Constants.metalName);
		PropertyService.addProperty(itemType.getProperties(), new Property(Constants.craftMultiplier, 14));

		itemType = new ItemType(Constants.ironName);
		itemType.getParentTypes().add(Constants.metalName);
		PropertyService.addProperty(itemType.getProperties(), new Property(Constants.craftMultiplier, 17));

		itemType = new ItemType(Constants.steelName);
		itemType.getParentTypes().add(Constants.metalName);
		PropertyService.addProperty(itemType.getProperties(), new Property(Constants.craftMultiplier, 20));

		itemType = new ItemType(Constants.titaniumName);
		itemType.getParentTypes().add(Constants.metalName);
		PropertyService.addProperty(itemType.getProperties(), new Property(Constants.craftMultiplier, 41));

		itemType = new ItemType(Constants.mithrilName);
		itemType.getParentTypes().add(Constants.metalName);
		PropertyService.addProperty(itemType.getProperties(), new Property(Constants.craftMultiplier, 110));

		itemType = new ItemType(Constants.daggerName);
		itemType.getParentTypes().add(Constants.meeleWeaponName);

		itemType = new ItemType(Constants.swordName);
		itemType.getParentTypes().add(Constants.meeleWeaponName);

		/////////////////////////
		
		Map<String, Object> processedTypes = new HashMap<String, Object>();
		Map<String, List<String>> unprocessedTypes = new HashMap<String, List<String>>();
		LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<String>();
		
		List<String> parentTypes;
		for (String typeName: ItemType.itemTypeList.keySet()) {
			parentTypes = new ArrayList<String>();
			parentTypes.addAll(ItemType.itemTypeList.get(typeName).getParentTypes());
			unprocessedTypes.put(typeName, parentTypes);
		}
		
		queue.add(Constants.objectName);

		List<String> requirements;
		while(!queue.isEmpty()) {
			String currentTypeName = queue.poll();

			processItemType(currentTypeName);
			
			processedTypes.put(currentTypeName, null);
			unprocessedTypes.remove(currentTypeName);
			
			for (String typeName: unprocessedTypes.keySet()) {
				requirements = unprocessedTypes.get(typeName);
				requirements.remove(currentTypeName);
				if (requirements.size() == 0) {
					queue.add(typeName);
				}
			}
		}
	}

	private static void processItemType(String currentTypeName) {
		long maxParentLevel = -1;
		ItemType currentType, parentType;
		
		currentType = ItemType.itemTypeList.get(currentTypeName);
		EntityProperties currentAllProperties = currentType.getAllProperties();
		Map<String, Object> currentAllTypes = currentType.getAllTypes();

		EntityProperties parentAllProperties;
		Map<String, Object> parentAllTypes;

		Queue<ItemType> parentTypesQueue = new PriorityQueue<ItemType>();
		for (String parentTypeName: currentType.getParentTypes()) {
			parentTypesQueue.offer(ItemType.itemTypeList.get(parentTypeName));
		}
		
		while (!parentTypesQueue.isEmpty()) {
			parentType = parentTypesQueue.poll();
			parentAllProperties = parentType.getAllProperties();
			parentAllTypes = parentType.getAllTypes();
			
			maxParentLevel = Math.max(maxParentLevel, parentType.getHierarchyLevel());
			for (String parentPropertyName: parentAllProperties.keySet()) {
				currentAllProperties.remove(parentPropertyName);
				currentAllProperties.addProperty(
						parentAllProperties.getPropertyByName(parentPropertyName));
			}
			
			for (String typeName: parentAllTypes.keySet()) {
				currentAllTypes.remove(typeName);
				currentAllTypes.put(typeName, null);
			}
		}

		EntityProperties properties = currentType.getProperties();
		for (String parentPropertyName: properties.keySet()) {
			currentAllProperties.remove(parentPropertyName);
			currentAllProperties.addProperty(
					properties.getPropertyByName(parentPropertyName));
		}

		currentAllTypes.put(currentTypeName, null);
		currentType.setHierarchyLevel(maxParentLevel + 1);
	}
	
	@SuppressWarnings("unused")
	private static void initializeSkillTypeHierarchy() {
		Skill crafting =		new Skill(Constants.skillCrafting,		60.0, null);
		Skill forging =			new Skill(Constants.skillForging,		40.0, crafting);
		Skill tailoring =		new Skill(Constants.skillTailoring,		40.0, crafting);
		Skill woodworking =		new Skill(Constants.skillWoodworking,	40.0, crafting);
		Skill weaponForging =	new Skill(Constants.skillWeaponForging,	20.0, forging);
		Skill armourForging =	new Skill(Constants.skillArmourForging,	20.0, forging);
		Skill swordCrafting =	new Skill(Constants.skillSwordCrafting,	8.0, weaponForging);
		Skill daggerCrafting =	new Skill(Constants.skillDaggerCrafting,8.0, weaponForging);
	}

	private static void initializeRecipes() {
		String name = Constants.daggerName;
		Skill skill = Skill.getSkillByName(Constants.skillDaggerCrafting);
		ItemType itemType = ItemType.getItemtypelist().get(name);
		Recipe daggerRecipe = new Recipe(name, itemType, skill);
		PropertyService.addProperty(daggerRecipe.getProperties(), new Property(Constants.resourcesNeeded, 3));

		name = Constants.swordName;
		skill = Skill.getSkillByName(Constants.skillSwordCrafting);
		itemType = ItemType.getItemtypelist().get(name);
		Recipe swordRecipe = new Recipe(name, itemType, skill);
		PropertyService.addProperty(swordRecipe.getProperties(), new Property(Constants.resourcesNeeded, 12));
	}
	
}
