package springGameTest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User {

	private final long userId;
	private final String name;
	private long energy;
	private long maxEnergy;
	private long money;
	private final EntityProperties properties;
	private final Inventory inventory;
	private final UserSkillGroup skills;
	private final RecipeGroup recipes;
	private final List<Event> eventList;

	public User(long userId, String name) {
		this.userId = userId;
		this.name = name;

		properties = new EntityProperties();
		inventory = new Inventory();
		recipes = new RecipeGroup();
		skills = new UserSkillGroup();
		eventList = new ArrayList<Event>();
	}

	public long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public long getEnergy() {
		return energy;
	}

	public void setEnergy(long energy) {
		this.energy = energy;
	}

	public long getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(long maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
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
				getPropertyByName(propertyName).getIntValue();
	}
	
	public double getFloatValue(String propertyName) {
		return properties.
				getPropertyByName(propertyName).getFloatValue();
	}
	
	public String getStringValue(String propertyName) {
		return properties.
				getPropertyByName(propertyName).getStringValue();
	}
	
	public Date getDateValue(String propertyName) {
		return properties.
				getPropertyByName(propertyName).getDateValue();
	}
	
	public boolean hasProperty(String propertyName) {
		return properties.hasProperty(propertyName);
	}

}
