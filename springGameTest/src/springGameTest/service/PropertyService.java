package springGameTest.service;

import springGameTest.model.EntityProperties;
import springGameTest.model.Property;
import springGameTest.model.PropertyType;
import springGameTest.model.WrongTypeException;

public class PropertyService {
	
	public static void sumProperty(Property currentProperty,
			Property otherProperty) {
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

	public static void addProperty (EntityProperties properties,
			Property newProperty, PropertyCollisionAction action) {
		Property currentProperty = properties.getPropertyByName(
				newProperty.getPropertyName());
		if (currentProperty == null) { action = PropertyCollisionAction.NewPrevails; }
		switch (action) {
		case ExistingPrevails:
			break;
		case Sum:
			sumProperty(currentProperty, newProperty);
			break;
		case NewPrevails:
		default:
			properties.addProperty(newProperty);
			break;
		}
	}

	public static void addProperty (EntityProperties properties, String propertyName,
			PropertyType propertyType, PropertyCollisionAction action) {
		addProperty(properties, new Property(propertyName, propertyType), action);
	}

	public static void addProperty (EntityProperties properties,
			Property newProperty) {
		addProperty(properties, newProperty,
				PropertyCollisionAction.ExistingPrevails);
	}

	public static void addProperty (EntityProperties properties,
			String propertyName, PropertyType propertyType) {
		addProperty(properties, new Property(propertyName, propertyType));
	}

}
