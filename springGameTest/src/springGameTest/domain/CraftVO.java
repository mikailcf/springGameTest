package springGameTest.domain;

import java.util.Collection;

import springGameTest.model.Inventory;
import springGameTest.model.Item;
import springGameTest.model.User;
import springGameTest.service.InventoryService;


public class CraftVO extends GameVO {

	private final Inventory availableResources = new Inventory();
	private String viewPage;
	private Item selectedRecipe;
	private Item craftedItem;

	public CraftVO(User user) {
		super(user);
		viewPage = "normal";
	}

	public Inventory getAvailableResources() {
		return availableResources;
	}

	public Collection<Item> getAvailableResourceList() {
		return availableResources.getItemList();
	}
	
	public String getViewPage() {
		return viewPage;
	}

	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	
	public Item getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(Item selectedRecipe) {
		this.selectedRecipe = selectedRecipe;
	}

	public Item getCraftedItem() {
		return craftedItem;
	}

	public void setCraftedItem(Item craftedItem) {
		this.craftedItem = craftedItem;
	}

	public long getAbsoluteValue(String propertyName) {
		return InventoryService.getAbsoluteValue(craftedItem, propertyName);
	}

	public String getPercentageValue(String propertyName) {
		return InventoryService.getPercentageValue(craftedItem, propertyName);
	}
	
	
}
