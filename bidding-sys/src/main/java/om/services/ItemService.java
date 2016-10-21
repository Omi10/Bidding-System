package om.services;

import java.util.List;

import inti.ws.spring.exception.client.BadRequestException;
import om.entities.Category;
import om.models.ItemModel;

public interface ItemService {

	public List<ItemModel> getItems() ;
	
	public ItemModel getItem(int itemId) throws BadRequestException ;

	public ItemModel addItem(ItemModel item) ;
	
	public ItemModel updateItem(int itemId,ItemModel ittem) ;
	
	public void deleteItem(int itemId) ;

}
