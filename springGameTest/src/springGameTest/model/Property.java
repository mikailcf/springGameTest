package springGameTest.model;

import java.util.Date;


public class Property {
	
	private final String propertyName;
	private final PropertyValue propertyValue;
	
	public Property (String propertyName, PropertyType propertyType) {
		this.propertyName = propertyName;
		this.propertyValue = new PropertyValue(propertyType);
	}
	
	public Property (String propertyName, long intValue) {
		this.propertyName = propertyName;
		this.propertyValue = new PropertyValue(intValue);
	}
	
	public Property (String propertyName, double floatValue) {
		this.propertyName = propertyName;
		this.propertyValue = new PropertyValue(floatValue);
	}
	
	public Property (String propertyName, String stringValue) {
		this.propertyName = propertyName;
		this.propertyValue = new PropertyValue(stringValue);
	}
	
	public Property (String propertyName, Date dateValue) {
		this.propertyName = propertyName;
		this.propertyValue = new PropertyValue(dateValue);
	}

	public String getPropertyName() {
		return propertyName;
	}

	public PropertyValue getPropertyValue() {
		return propertyValue;
	}

	public boolean equals(Property other) {
		return this.propertyName == other.propertyName &&
				this.propertyValue.equals(other.propertyValue);
	}

}
