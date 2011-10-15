package springGameTest.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntityProperties {

	private final Map<String, Property> propertyList;
	
	public EntityProperties() {
		propertyList = new HashMap<String, Property>();
	}

	public Property getPropertyByName (String propertyName) {
		return propertyList.get(propertyName);
	}

	public Property getPropertyByNameWithDefault (String propertyName) {
		Property propertyValue = propertyList.get(propertyName);
		return propertyValue == null ? 
				new Property(propertyName, PropertyType.Integer) : propertyValue;
	}

	public void addProperty(Property newProperty) {
		propertyList.put(newProperty.getPropertyName(), newProperty);
	}
	
	public void clear() {
		propertyList.clear();
	}
	
	public void remove(String propertyName) {
		propertyList.remove(propertyName);
	}
	
	public void copy(EntityProperties newProperties) {
		for (String propertyName: propertyList.keySet()) {
			newProperties.addProperty(propertyList.get(propertyName).copy());
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

	public Collection<Property> values() {
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
