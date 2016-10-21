package om.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import om.dao.CategoryDao;
import om.dao.ItemDao;
import om.entities.Category;
import om.models.ItemModel;
import om.utilities.MappingUtility;
import om.entities.Item;

import inti.ws.spring.exception.client.BadRequestException;

/**
 * Business logic related to Item
 * @author omprakashnirankari
 *
 */
@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	MappingUtility mUtility;

	@Autowired
	ItemDao itemDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	
	@Override
	public List<ItemModel> getItems() {
		List<Item> items = (List<Item>) itemDao.getItems();
		List<ItemModel> itemModels = mUtility.itemsToItemModels(items);
		return itemModels;
	}
	
	
	@Override
	public ItemModel getItem(int itemId) throws BadRequestException {
		if(itemId<0)
			throw new BadRequestException("Invalid ItemId parameters");
		Item item=itemDao.getItem(itemId);
		ItemModel itemModel = mUtility.itemToItemModel(item);
		return itemModel;
	}
	
	@Override
	public ItemModel addItem(ItemModel itemModel) 
	{
		Item item=mUtility.itemModelToItem(itemModel);
		itemDao.save(item);
		return itemModel;
	}
	
	@Override
	public ItemModel updateItem(int itemId,ItemModel itemModel) 
	{
		Item item=itemDao.getItem(itemId);
		mUtility.updateItem (item,itemModel);
		itemDao.update(item);
		return itemModel;
	}

	@Override
	public void deleteItem(int itemId)
	{
		Item item = new Item();
		item.setId(itemId);
		itemDao.delete(item);
	}
	
}
