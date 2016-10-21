package om.dao;

import java.util.List;

import om.entities.Bid;

public interface BidDao {
	
	public List<Bid> getBids();
	
	public Bid getBid(int bidId);
	
	public void save(Bid bid);
	
	public void update (Bid Bid);
	
	public void delete (Bid bid);
	
}
