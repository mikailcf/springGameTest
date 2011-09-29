package springGameTest.model;

import java.util.Date;

public class Event {
	
	private final Date date;
	private final String message;
	private boolean isNew;
	
	public Event(String message) {
		this(message, true);
	}
	
	public Event(String message, boolean isNew) {
		date = new Date();
		this.message = message;
		this.isNew = isNew;
	}

	public boolean isNew() {
		return isNew;
	}

	public boolean isEmpty() {
		return message.equals("");
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		isNew = false;
		return message;
	}

}
