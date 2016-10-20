package om.services;

import java.util.List;

import om.entities.Category;
import om.models.ItemModel;

public interface ItemService {

	public List<ItemModel> getItems() ;
	
	public ItemModel getItem(int itemId) ;

	public ItemModel addItem(ItemModel Item) ;
	
	public ItemModel updateItem(int itemId,ItemModel Item) ;
	

	public void deleteItem(int ItemId) ;


}
