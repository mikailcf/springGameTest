package springGameTest.model;

import java.util.Date;


public class PropertyValue {
	
	private final PropertyType valueType;
	private long intValue;
	private double floatValue;
	private String stringValue;
	private Date dateValue;

	public PropertyValue (PropertyType valueType) {
		this.valueType = valueType;
	}

	public PropertyValue (long intValue) {
		this.valueType = PropertyType.Integer;
		this.intValue = intValue;
	}

	public PropertyValue (double floatValue) {
		this.valueType = PropertyType.Float;
		this.floatValue = floatValue;
	}

	public PropertyValue (String stringValue) {
		this.valueType = PropertyType.String;
		this.stringValue = stringValue;
	}

	public PropertyValue (Date dateValue) {
		this.valueType = PropertyType.Date;
		this.dateValue = dateValue;
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
	
	public boolean equals(PropertyValue propertyValue) {
		return ((this.valueType == propertyValue.valueType) &&
				(this.intValue == propertyValue.intValue) &&
				(this.floatValue == propertyValue.floatValue) &&
				((this.stringValue == null && propertyValue.stringValue == null) ||
				 (this.stringValue != null && this.stringValue.equals(propertyValue.stringValue))) &&
				((this.dateValue == null && propertyValue.dateValue == null) ||
				 (this.dateValue != null && this.dateValue.equals(propertyValue.dateValue))));
	}

	public PropertyValue copy() {
		PropertyValue newPropertyValue = new PropertyValue (valueType);
		newPropertyValue.intValue = this.intValue;
		newPropertyValue.floatValue = this.floatValue;
		newPropertyValue.stringValue = this.stringValue;
		newPropertyValue.dateValue = this.dateValue;
		return newPropertyValue;
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
