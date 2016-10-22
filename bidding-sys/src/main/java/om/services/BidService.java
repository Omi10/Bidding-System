package om.services;

import java.util.List;

import om.models.BidModel;
import om.models.MakeBidModel;

public interface BidService {

	public List<BidModel> getBids(int itemId);

	public BidModel getBid(int bidId);

	public BidModel addBid(int itemId, MakeBidModel makeBidModel);

	public BidModel updateBid(int bidId, BidModel bid);

	public void deleteBid(int BidId);
	
	public BidModel getBidResult(int itemId);

}
