package springGameTest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemType {

	public static final Map<String, ItemType> itemTypeList =
			new HashMap<String, ItemType>();

	private final EntityProperties properties;
	private final EntityProperties allProperties;
	private final String name;
	private final List<String> parentTypes;
	private final Map<String, Object> allTypes;
	private long hierarchyLevel;
	
	public ItemType (String name) {
		this.name = name;
		properties = new EntityProperties();
		allProperties = new EntityProperties();
		parentTypes = new ArrayList<String>();
		allTypes = new HashMap<String, Object>();
		hierarchyLevel = 0;
		
		itemTypeList.put(name, this);
	}

	public long getHierarchyLevel() {
		return hierarchyLevel;
	}

	public void setHierarchyLevel(long hierarchyLevel) {
		this.hierarchyLevel = hierarchyLevel;
	}

	public static Map<String, ItemType> getItemtypelist() {
		return itemTypeList;
	}

	public String getName() {
		return name;
	}

	public List<String> getParentTypes() {
		return parentTypes;
	}

	public Map<String, Object> getAllTypes() {
		return allTypes;
	}

	public EntityProperties getProperties() {
		return properties;
	}

	public EntityProperties getAllProperties() {
		return allProperties;
	}
	
	public long getIntValue(String propertyName) {
		return allProperties.getPropertyValueByName(propertyName).getIntValue();
	}
	
	public double getFloatValue(String propertyName) {
		return allProperties.getPropertyValueByName(propertyName).getFloatValue();
	}
	
	public String getStringValue(String propertyName) {
		return allProperties.getPropertyValueByName(propertyName).getStringValue();
	}
	
	public Date getDateValue(String propertyName) {
		return allProperties.getPropertyValueByName(propertyName).getDateValue();
	}
	
	public boolean hasProperty(String propertyName) {
		return allProperties.hasProperty(propertyName);
	}
	
	public boolean equals(ItemType other) {
		return this.name == other.name;
	}
	
	public String toString() {
		return "ItemType:[name: " + name +
				", properties:" + properties.toString() + "]";
	}
	
	public boolean isType(String name) {
		return this.name == name;
	}
	
	public boolean isTypeOrSubType(String name) {
		return allTypes.containsKey(name);
	}

}
