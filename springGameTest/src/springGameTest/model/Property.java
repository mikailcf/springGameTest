package springGameTest.model;

import java.util.Date;


public class Property {
	
	private final String propertyName;
	private final PropertyType valueType;
	private long intValue;
	private double floatValue;
	private String stringValue;
	private Date dateValue;
	
	public Property (String propertyName, PropertyType valueType) {
		this.propertyName = propertyName;
		this.valueType = valueType;
	}
	
	public Property (String propertyName, long intValue) {
		this.propertyName = propertyName;
		this.valueType = PropertyType.Integer;
		this.intValue = intValue;
	}
	
	public Property (String propertyName, double floatValue) {
		this.propertyName = propertyName;
		this.valueType = PropertyType.Float;
		this.floatValue = floatValue;
	}
	
	public Property (String propertyName, String stringValue) {
		this.propertyName = propertyName;
		this.valueType = PropertyType.String;
		this.stringValue = stringValue;
	}
	
	public Property (String propertyName, Date dateValue) {
		this.propertyName = propertyName;
		this.valueType = PropertyType.Date;
		this.dateValue = dateValue;
	}

	public String getPropertyName() {
		return propertyName;
	}
	
	public PropertyType getValueType() {
		return valueType;
	}

	public long getIntValue() {
		if (valueType != PropertyType.Integer) throw new WrongTypeException();
		return intValue;
	}

	public void setIntValue(long intValue) {
		if (valueType != PropertyType.Integer) throw new WrongTypeException();
		this.intValue = intValue;
	}

	public double getFloatValue() {
		if (valueType != PropertyType.Float) throw new WrongTypeException();
		return floatValue;
	}

	public void setFloatValue(double floatValue) {
		if (valueType != PropertyType.Float) throw new WrongTypeException();
		this.floatValue = floatValue;
	}

	public String getStringValue() {
		if (valueType != PropertyType.String) throw new WrongTypeException();
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		if (valueType != PropertyType.String) throw new WrongTypeException();
		this.stringValue = stringValue;
	}

	public Date getDateValue() {
		if (valueType != PropertyType.Date) throw new WrongTypeException();
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		if (valueType != PropertyType.Date) throw new WrongTypeException();
		this.dateValue = dateValue;
	}

	public boolean equals(Property other) {
		return this.propertyName == other.propertyName &&
				((this.valueType == other.valueType) &&
				 (this.intValue == other.intValue) &&
				 (this.floatValue == other.floatValue) &&
				 ((this.stringValue == null && other.stringValue == null) ||
				  (this.stringValue != null && this.stringValue.equals(other.stringValue))) &&
				 ((this.dateValue == null && other.dateValue == null) ||
				  (this.dateValue != null && this.dateValue.equals(other.dateValue))));
	}

	public Property copy() {
		Property newProperty = new Property (propertyName, valueType);
		newProperty.intValue = this.intValue;
		newProperty.floatValue = this.floatValue;
		newProperty.stringValue = this.stringValue;
		newProperty.dateValue = this.dateValue;
		return newProperty;
	}
	
	public String toString() {
		switch (valueType) {
		case Integer: return "Integer " + intValue;
		case Float: return "Float " + floatValue;
		case String: return "String " + stringValue;
		case Date: return "Date " + dateValue;
		}
		return "Unknouwn";
	}

	public int hashCode() {
		switch (valueType) {
		case Integer: return (int)intValue*4 + 1;
		case Float: return (int)floatValue*4 + 2;
		case String: return stringValue.hashCode()*4 + 3;
		case Date: return dateValue.hashCode()*4 + 4;
		}
		return -1;
	}
	
}
