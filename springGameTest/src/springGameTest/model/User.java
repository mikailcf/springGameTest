package springGameTest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User {

	private final long userId;
	private final EntityProperties properties;
	private final Inventory inventory;
	private final UserSkillGroup skills;
	private final RecipeGroup recipes;
	private final List<Event> eventList;

	public User(long userId) {
		this.userId = userId;

		properties = new EntityProperties();
		inventory = new Inventory();
		recipes = new RecipeGroup();
		skills = new UserSkillGroup();
		eventList = new ArrayList<Event>();
	}

	public long getUserId() {
		return userId;
	}

	public EntityProperties getProperties() {
		return properties;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public RecipeGroup getRecipes() {
		return recipes;
	}
	
	public UserSkillGroup getSkills() {
		return skills;
	}

	public List<Event> getEventList() {
		return eventList;
	}
	
	public long getIntValue(String propertyName) {
		return properties.
				getPropertyValueByName(propertyName).getIntValue();
	}
	
	public double getFloatValue(String propertyName) {
		return properties.
				getPropertyValueByName(propertyName).getFloatValue();
	}
	
	public String getStringValue(String propertyName) {
		return properties.
				getPropertyValueByName(propertyName).getStringValue();
	}
	
	public Date getDateValue(String propertyName) {
		return properties.
				getPropertyValueByName(propertyName).getDateValue();
	}
	
	public boolean hasProperty(String propertyName) {
		return properties.hasProperty(propertyName);
	}

}
