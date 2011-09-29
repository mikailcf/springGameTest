package springGameTest.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntityProperties {

	private final Map<String, PropertyValue> propertyList;
	
	public EntityProperties() {
		propertyList = new HashMap<String, PropertyValue>();
	}

	public PropertyValue getPropertyValueByName (String propertyName) {
		return propertyList.get(propertyName);
	}

	public PropertyValue getPropertyValueByNameWithDefault (String propertyName) {
		PropertyValue propertyValue = propertyList.get(propertyName);
		return propertyValue == null ? new PropertyValue(PropertyType.Integer) : propertyValue;
	}

	public void addProperty(String propertyName, PropertyValue propertyValue) {
		propertyList.put(propertyName, propertyValue);
	}
	
	public void clear() {
		propertyList.clear();
	}
	
	public void copy(EntityProperties newProperties) {
		for (String propertyName: propertyList.keySet()) {
			newProperties.addProperty(propertyName, propertyList.get(propertyName).copy());
		}
	}

	public boolean hasProperty(String propertyName) {
		return propertyList.containsKey(propertyName);
	}

	public boolean equals(EntityProperties other) {
		if (!(this.propertyList.keySet().equals(other.keySet()))) {
			return false;
		}
		for (String propertyName: this.propertyList.keySet()) {
			if (!(this.propertyList.get(propertyName).
					equals(other.propertyList.get(propertyName)))) {
				return false;
			}
		}
		return true;
	}

	public Set<String> keySet() {
		return propertyList.keySet();
	}

	public int size() {
		return propertyList.size();
	}

	public Collection<PropertyValue> values() {
		return propertyList.values();
	}
	
	public String toString() {
		String result = "";
		for (String propertyName: propertyList.keySet()) {
			result = result + (result.equals("") ? "[" : ", ") +
					propertyName + ":" +propertyList.get(propertyName);
		}
		return result + "]";
	}

}
