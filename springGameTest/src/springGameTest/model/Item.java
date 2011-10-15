package springGameTest.model;

import java.util.Date;

public class Item {

	public static final Inventory itemTemplateList = new Inventory();
	private static long nextItemId = 1;

	private final EntityProperties properties;
	private final long itemId;
	private final ItemType itemType;
	private String name;
	private long quantity;
	private long value;
	
	public Item (String itemType) {
		this(ItemType.itemTypeList.get(itemType));
	}
	
	public Item (ItemType itemType) {
		this(itemType, nextItemId++);
	}
	
	public Item (String itemType, String name) {
		this(ItemType.itemTypeList.get(itemType), nextItemId++, name);
	}
	
	public Item (ItemType itemType, String name) {
		this(itemType, nextItemId++, name);
	}
	
	public Item (String itemType, long itemId) {
		this (ItemType.itemTypeList.get(itemType), itemId);
	}
	
	public Item (ItemType itemType, long itemId) {
		this (itemType, itemId, itemType.getName());
	}
	
	public Item (String itemType, long itemId, String name) {
		this (ItemType.itemTypeList.get(itemType), itemId, name);
	}
	
	public Item (ItemType itemType, long itemId, String name) {
		this.itemType = itemType;
		this.itemId = itemId;
		properties = new EntityProperties();
		this.name = name;
		quantity = 1;
		value = 0;
	}
	
	public Item copyNewId() {
		return copy(new Item(itemType));
	}
	
	public Item copySameId() {
		return copy(new Item(itemType, itemId));
	}
	
	public Item copy(Item newItem) {
		newItem.properties.clear();
		properties.copy(newItem.properties);
		newItem.name = this.name;
		newItem.quantity = this.quantity;
		newItem.value = this.value;
		return newItem;
	}

	public long getItemId() {
		return itemId;
	}

	public EntityProperties getProperties() {
		return properties;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getIntValue(String propertyName) {
		Property propertyValue = properties.
				getPropertyByName(propertyName);
		if (propertyValue == null) {
			return itemType.getIntValue(propertyName);
		}
		return propertyValue.getIntValue();
	}
	
	public double getFloatValue(String propertyName) {
		Property propertyValue = properties.
				getPropertyByName(propertyName);
		if (propertyValue == null) {
			return itemType.getFloatValue(propertyName);
		}
		return propertyValue.getFloatValue();
	}
	
	public String getStringValue(String propertyName) {
		Property propertyValue = properties.
				getPropertyByName(propertyName);
		if (propertyValue == null) {
			return itemType.getStringValue(propertyName);
		}
		return propertyValue.getStringValue();
	}
	
	public Date getDateValue(String propertyName) {
		Property propertyValue = properties.
				getPropertyByName(propertyName);
		if (propertyValue == null) {
			return itemType.getDateValue(propertyName);
		}
		return propertyValue.getDateValue();
	}
	
	public boolean isType(String name) {
		return itemType.isType(name);
	}
	
	public boolean isTypeOrSubType(String name) {
		return itemType.isTypeOrSubType(name);
	}
	
	public boolean hasProperty(String propertyName) {
		return properties.hasProperty(propertyName);
	}
	
	public boolean equals(Item other) {
		return this.itemId == other.itemId &&
				this.properties.equals(other.properties);
	}
	
	public String toString() {
		return "Item:[itemId: " + itemId +
				", properties:" + properties.toString() + "]";
	}

}
