package springGameTest.model;

import java.util.Date;

public class Recipe {

	private static final RecipeGroup recipeList = new RecipeGroup();
	private static long nextRecipeId = 1;

	private final EntityProperties properties;
	private final long recipeId;
	private final String name;
	private final ItemType itemType;
	private final Skill skill;
	
	public static Recipe getRecipe(String name) {
		return recipeList.getRecipe(name);
	}
	
	public Recipe(String name, ItemType itemType, Skill skill) {
		recipeId = nextRecipeId++;
		this.name = name;
		this.itemType = itemType;
		this.skill = skill;
		properties = new EntityProperties();
		recipeList.addRecipe(this);
	}

	public EntityProperties getProperties() {
		return properties;
	}

	public long getRecipeId() {
		return recipeId;
	}

	public String getName() {
		return name;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public Skill getSkill() {
		return skill;
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

}
