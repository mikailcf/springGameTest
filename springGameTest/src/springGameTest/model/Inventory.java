package springGameTest.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import springGameTest.service.InventoryService;

public class Inventory {

	private final Map<Integer, Item> itemList;
	private final Map<String, Item> itemListByName;
	
	public Inventory() {
		itemList = new HashMap<Integer, Item>();
		itemListByName = new HashMap<String, Item>();
	}

	public Item getItemById(Integer itemId) {
		return itemList.get(itemId);
	}

	public Item getItemById(long itemId) {
		return getItemById(new Integer(""+itemId));
	}

	public Item getItemByName(String itemName) {
		return itemListByName.get(itemName);
	}

	public void addItem(Item newItem, String newItemName) {
		itemList.put(new Integer(""+newItem.getItemId()), newItem);
		itemListByName.put(newItemName, newItem);
	}

	public void removeById(long itemId) {
		removeById(new Integer(""+itemId));
	}

	public void removeById(Integer itemId) {
		itemListByName.remove(InventoryService.getItemName(itemList.get(itemId)));
		itemList.remove(itemId);
	}

	public void removeByName(String itemName) {
		itemList.remove(new Integer(""+itemListByName.get(itemName).getItemId()));
		itemListByName.remove(itemName);
	}
	
	public Collection<Item> getItemList() {
		return itemList.values();
	}
	
	public boolean equals (Inventory otheInventory) {
		ArrayList<Item> thisItemList = new ArrayList<Item>(itemList.values());
		ArrayList<Item> otherItemList = new ArrayList<Item>(otheInventory.
				itemList.values());
		
		for (Item i: thisItemList) {
			if (!(otherItemList.contains(i))) {
				return false;
			}
		}
		
		for (Item i: otherItemList) {
			if (!(thisItemList.contains(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	public String toString() {
		return itemList.values().toString();
	}

}
