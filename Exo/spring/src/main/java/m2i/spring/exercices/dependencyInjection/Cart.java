package m2i.spring.exercices.dependencyInjection;

import java.util.*;

public class Cart {

	List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeAll() {
		items.clear();	
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> cart) {
		this.items = cart;
	}

}
