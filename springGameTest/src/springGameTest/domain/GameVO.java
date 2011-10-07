package springGameTest.domain;

import java.util.Collection;
import java.util.Date;

import springGameTest.model.EntityProperties;
import springGameTest.model.Event;
import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.User;
import springGameTest.model.UserSkill;
import springGameTest.model.UserSkillGroup;
import springGameTest.service.EventService;
import springGameTest.service.UserService;

public class GameVO {

	private final User user;
	private final long numberOfEvents;
	
	public GameVO(User user) {
		this(user, 10);
	}
	
	public GameVO(User user, long numberOfEvents) {
		this.user = user;
		this.numberOfEvents = numberOfEvents;
	}

	public User getUser() {
		return user;
	}

	public EntityProperties getProperties() {
		return user.getProperties();
	}

	public Inventory getInventory() {
		return user.getInventory();
	}

	public Collection<Item> getItemList() {
		return user.getInventory().getItemList();
	}

	public Inventory getRecipes() {
		return user.getRecipes();
	}

	public Collection<Item> getRecipeList() {
		return user.getRecipes().getItemList();
	}

	public UserSkillGroup getSkills() {
		return user.getSkills();
	}

	public Collection<UserSkill> getSkillList() {
		return user.getSkills().values();
	}

	public Collection<Event> getEventList() {
		return getEventList(numberOfEvents, numberOfEvents);
	}

	public Collection<Event> getEventList(long amount, long minimum) {
		return EventService.getEventList(user, amount, minimum);
	}
	
	public long getIntValue(String propertyName) {
		return user.getIntValue(propertyName);
	}
	
	public double getFloatValue(String propertyName) {
		return user.getFloatValue(propertyName);
	}
	
	public String getStringValue(String propertyName) {
		return user.getStringValue(propertyName);
	}
	
	public Date getDateValue(String propertyName) {
		return user.getDateValue(propertyName);
	}
	
	public long getBuyValue(Item item) {
		return UserService.getBuyValue(user, item);
	}
	
	public long getSellValue(Item item) {
		return UserService.getSellValue(user, item);
	}

}
