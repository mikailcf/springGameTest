package springGameTest.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RecipeGroup {

	private final Map<String, Recipe> recipeListByName;
	private final Map<Integer, Recipe> recipeListById;
	
	public RecipeGroup() {
		recipeListByName = new HashMap<String, Recipe>();
		recipeListById = new HashMap<Integer, Recipe>();
	}

	public Recipe getRecipe (long recipeId) {
		return getRecipe(new Integer(""+recipeId));
	}

	public Recipe getRecipe (Integer recipeId) {
		return recipeListById.get(recipeId);
	}

	public Recipe getRecipe (String recipeName) {
		return recipeListByName.get(recipeName);
	}

	public void addRecipe (Recipe recipe) {
		recipeListByName.put(recipe.getName(), recipe);
		recipeListById.put(new Integer(""+recipe.getRecipeId()), recipe);
	}
	
	public void clear() {
		recipeListByName.clear();
		recipeListById.clear();
	}
	
	public void remove(long recipeId) {
		remove(new Integer(""+recipeId));
	}
	
	public void remove(Integer recipeId) {
		recipeListByName.remove(recipeListById.get(recipeId).getName());
		recipeListById.remove(recipeId);
	}
	
	public void remove(String recipeName) {
		recipeListById.remove(new Integer(
				""+recipeListByName.get(recipeName).getRecipeId()));
		recipeListByName.remove(recipeName);
	}

	public boolean hasRecipe(long recipeId) {
		return hasRecipe(new Integer(""+recipeId));
	}

	public boolean hasRecipe(Integer recipeId) {
		return recipeListById.containsKey(recipeId);
	}

	public boolean hasRecipe(String recipeName) {
		return recipeListByName.containsKey(recipeName);
	}

	public boolean equals(RecipeGroup other) {
		if (!(this.recipeListByName.keySet().equals(
				other.recipeListByName.keySet()))) {
			return false;
		}
		for (String propertyName: this.recipeListByName.keySet()) {
			if (!(this.recipeListByName.get(propertyName).
					equals(other.recipeListByName.get(propertyName)))) {
				return false;
			}
		}
		return true;
	}

	public Set<String> stringKeySet() {
		return recipeListByName.keySet();
	}

	public Set<Integer> integerKeySet() {
		return recipeListById.keySet();
	}

	public int size() {
		return recipeListByName.size();
	}

	public Collection<Recipe> values() {
		return recipeListByName.values();
	}
	
	public String toString() {
		String result = "";
		for (String propertyName: recipeListByName.keySet()) {
			result = result + (result.equals("") ? "[" : ", ") +
					propertyName + ":" +recipeListByName.get(propertyName);
		}
		return result + "]";
	}

}