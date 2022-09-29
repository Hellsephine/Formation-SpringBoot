package m2i.spring.examples.di;

import java.util.ArrayList;
import java.util.List;


public class Cart {

	private List<String> items = new ArrayList<String>();
	
	public Cart()
	{
		
	}
	
	public void addItem(String item)
	{
		items.add(item);
	}
	
	public int itemCount()
	{
		return items.size();
	}
}
