package springGameTest.service;

import springGameTest.model.EntityProperties;
import springGameTest.model.Property;
import springGameTest.model.PropertyType;
import springGameTest.model.PropertyValue;
import springGameTest.model.WrongTypeException;

public class PropertyService {
	
	public static void sumProperty(PropertyValue currentProperty,
			PropertyValue otherProperty) {
		if (currentProperty.getValueType() != otherProperty.getValueType()) {
			throw new WrongTypeException();
		}
		switch (currentProperty.getValueType()) {
		case Integer:
			currentProperty.setIntValue(
					currentProperty.getIntValue() + otherProperty.getIntValue());
			break;
		case Float:
			currentProperty.setFloatValue(
					currentProperty.getFloatValue() + otherProperty.getFloatValue());
			break;
		case String:
			currentProperty.setStringValue(
					currentProperty.getStringValue() + otherProperty.getStringValue());
			break;
		}
	}

	public static void addProperty (EntityProperties properties, String propertyName,
			PropertyValue propertyValue, PropertyCollisionAction action) {
		PropertyValue currentProperty = properties.getPropertyValueByName(propertyName);
		if (currentProperty == null) { action = PropertyCollisionAction.NewPrevails; }
		switch (action) {
		case ExistingPrevails:
			break;
		case Sum:
			sumProperty(currentProperty, propertyValue);
			break;
		case NewPrevails:
		default:
			properties.addProperty(propertyName, propertyValue);
			break;
		}
	}

	public static void addProperty (EntityProperties properties,
			String propertyName, PropertyValue propertyValue) {
		addProperty(properties, propertyName, propertyValue,
				PropertyCollisionAction.ExistingPrevails);
	}

	public static void addProperty (EntityProperties properties, String propertyName,
			PropertyType propertyType, PropertyCollisionAction action) {
		addProperty(properties, propertyName,
				new PropertyValue(propertyType), action);
	}

	public static void addProperty (EntityProperties properties,
			Property newProperty, PropertyCollisionAction action) {
		addProperty(properties, newProperty.getPropertyName(),
				newProperty.getPropertyValue(), action);
	}

	public static void addProperty (EntityProperties properties,
			String propertyName, PropertyType propertyType) {
		addProperty(properties, propertyName,
				new PropertyValue(propertyType));
	}

	public static void addProperty (EntityProperties properties,
			Property newProperty) {
		addProperty(properties, newProperty.getPropertyName(),
				newProperty.getPropertyValue());
	}

}
