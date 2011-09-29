package springGameTest.model;

import java.util.Date;

public class Item {

	private static long nextItemId = 1;

	private final EntityProperties properties;
	private final long itemId;
	
	private static long getNextItemId () {
		return nextItemId++;
	}
	
	public Item () {
		itemId = getNextItemId();
		properties = new EntityProperties();
	}
	
	public Item (long itemId) {
		this.itemId = itemId;
		properties = new EntityProperties();
	}
	
	public Item copyNewId() {
		return copy(new Item());
	}
	
	public Item copySameId() {
		return copy(new Item(itemId));
	}
	
	public Item copy(Item newItem) {
		newItem.properties.clear();
		properties.copy(newItem.properties);
		return newItem;
	}

	public long getItemId() {
		return itemId;
	}

	public EntityProperties getProperties() {
		return properties;
	}
	
	public long getIntValue(String propertyName) {
		return properties.
				getPropertyValueByNameWithDefault(propertyName).
				getIntValue();
	}
	
	public double getFloatValue(String propertyName) {
		return properties.
				getPropertyValueByNameWithDefault(propertyName).
				getFloatValue();
	}
	
	public String getStringValue(String propertyName) {
		return properties.
				getPropertyValueByNameWithDefault(propertyName).
				getStringValue();
	}
	
	public Date getDateValue(String propertyName) {
		return properties.
				getPropertyValueByNameWithDefault(propertyName).
				getDateValue();
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
