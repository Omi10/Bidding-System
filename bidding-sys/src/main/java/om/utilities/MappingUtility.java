package om.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;
import om.entities.User;
import om.entities.Bid;
import om.entities.Item;
import om.models.BidModel;
import om.models.ItemModel;
import om.models.MakeBidModel;

@Service
public class MappingUtility {

	public ItemModel itemToItemModel(Item item) {
		ItemModel itemModel = new ItemModel();
		itemModel.setItemId(item.getId());
		itemModel.setName(item.getItem());
		
		if (item.getBidType() != null && item.getBidType() == false)
			itemModel.setBidType("Closed");
		else if (item.getBidType() != null && item.getBidType() == true)
			itemModel.setBidType("Open");
		if (item.getUser() != null)
			itemModel.setOwner(item.getUser().getName());

		itemModel.setDescription(item.getDescription());
		itemModel.setStartBidAmount(item.getInitialPrice());
		System.out.println(item.getEndTime());
		Date bidTime = item.getEndTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(bidTime));
		itemModel.setBidEndTime(sdf.format(bidTime));
		return itemModel;
	}

	public List<ItemModel> itemsToItemModels(List<Item> items) {
		List<ItemModel> itemList = new ArrayList<>();
		for (Item i : items)
			itemList.add(itemToItemModel(i));
		return itemList;
	}

	public Item itemModelToItem(ItemModel itemModel) {
		Item item = new Item();
		item.setItem(itemModel.getName());
		item.setInitialPrice(itemModel.getStartBidAmount());
		item.setDescription(itemModel.getDescription());
		//item.setEndTime(itemModel.getbidEndTime());
		return item;
	}

	public ItemModel updateItem(Item item, ItemModel itemModel) {
		item.setInitialPrice(itemModel.getStartBidAmount());
		return itemModel;
	}

	public BidModel bidToBidModel(Bid bid) {
		BidModel bidModel = new BidModel();
		bidModel.setBidId(bid.getId());
		bidModel.setItem(bid.getItem().getItem()); // Get the Item Entity object
													// then fetch the item name
													// from that object
		bidModel.setLatestBid(bid.isIsRecent());
		bidModel.setWon(bid.isBidWon());
		bidModel.setMadeBy(bid.getUser().getName());
		bidModel.setBid_value(bid.getBidAmount());
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		bidModel.setBidTime(currentTime);
		return bidModel;
	}

	public List<BidModel> bidsToBidModels(List<Bid> bids) {
		List<BidModel> bidModels = new ArrayList<>();
		for (Bid bid : bids) {
			bidModels.add(bidToBidModel(bid));
		}
		return bidModels;
	}

	public Bid makeBidModelToBid(int itemId, MakeBidModel makeBidModel) {
		Bid bid=new Bid();
		User user=new User();
		Item item=new Item();
		item.setId(itemId);
		user.setId(makeBidModel.getBidderId());
		bid.setUser(user);
		bid.setItem(item);
		bid.setBidAmount(makeBidModel.getBid_value());	
		Date dt = new Date();
		bid.setBidTime(dt);
		return bid;
		
	}

}
