package om.models;


import java.util.Date;

import om.entities.Item;
import om.entities.User;

public class BidModel 
{	
	private int bidId;
	private String madeBy;
	private String item;
	private int bid_value;
	private boolean isLatestBid;
	private boolean isWon;
	
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	
	public String getMadeBy() {
		return madeBy;
	}
	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getBid_value() {
		return bid_value;
	}
	public void setBid_value(int bid_value) {
		this.bid_value = bid_value;
	}
	public boolean isLatestBid() {
		return isLatestBid;
	}
	public void setLatestBid(boolean isLatestBid) {
		this.isLatestBid = isLatestBid;
	}
	public boolean isWon() {
		return isWon;
	}
	public void setWon(boolean isWon) {
		this.isWon = isWon;
	}
}

