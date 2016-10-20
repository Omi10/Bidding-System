package om.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import om.entities.Item;
import om.models.ItemModel;


@Service
public class MappingUtility {
  
	public ItemModel itemToItemModel (Item item)
	{
		ItemModel itemModel=new ItemModel();
		itemModel.setItemId(item.getId());
		itemModel.setName(item.getItem());
		
		if(item.getBidType()!=null && item.getBidType() ==false)
			itemModel.setBidType("Closed");
		else if(item.getBidType()!=null && item.getBidType()==true)
			itemModel.setBidType("Open");
		if(item.getUser()!=null)
		  itemModel.setOwner(item.getUser().getName());
		
	    itemModel.setDescription(item.getDescription());
	    itemModel.setStartBidAmount(item.getInitialPrice());
		itemModel.setbidEndTime(item.getEndTime());		
		return itemModel;
	}
	
	
	public List<ItemModel> itemsToItemModels (List<Item> items)
	{
		List<ItemModel> itemList=new ArrayList<>();
		for(Item i :items)
		  itemList.add(itemToItemModel(i));
		return itemList;
	}
	
	public Item itemModelToItem(ItemModel itemModel)
	{
		Item item=new Item();
		item.setItem(itemModel.getName());
		item.setInitialPrice(itemModel.getStartBidAmount());
		item.setDescription(itemModel.getDescription());
		item.setEndTime(itemModel.getbidEndTime());
		return item;
	}
	
	public ItemModel updateItem(Item item,ItemModel itemModel)
	{
		item.setInitialPrice(itemModel.getStartBidAmount());
		return itemModel;
	}
		
}
