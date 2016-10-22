package om.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import om.dao.BidDao;
import om.entities.Bid;
import om.models.BidModel;
import om.models.MakeBidModel;
import om.utilities.MappingUtility;

@Service
public class BidServiceImp implements BidService {

	@Autowired
	MappingUtility mUtility;

	@Autowired
	BidDao bidDao;

	@Override
	public List<BidModel> getBids(int itemId) {
		List<Bid> bids = (List<Bid>) bidDao.getBids();
		List<BidModel> bidModels = mUtility.bidsToBidModels(bids);
		return bidModels;
	}

	@Override
	public BidModel getBid(int bidId) {
		Bid bid = bidDao.getBid(bidId);
		BidModel bidModel = mUtility.bidToBidModel(bid);
		return bidModel;
	}

	@Override
	public BidModel addBid(int itemId, MakeBidModel makeBidModel) {
		 Bid bid=mUtility.makeBidModelToBid(itemId, makeBidModel);
		 bidDao.save(bid);
		 return mUtility.bidToBidModel(bid);
	}

	@Override
	public BidModel updateBid(int bidId, BidModel bidModel) {
		/*
		 * Bid bid=bidDao.getBid(bidId); mUtility.updateBid(bid,bidModel);
		 * bidDao.update(bid); return bidModel;
		 */
		return null;
	}
	
	@Override
	public BidModel getBidResult(int itemId) {	
		Bid bid =  bidDao.getBidResult(itemId);
		BidModel bidModel = mUtility.bidToBidModel(bid);
		return bidModel;	
	}
	
	

	@Override
	public void deleteBid(int bidId) {
		Bid bid = new Bid();
		bid.setId(bidId);
		bidDao.delete(bid);
	}

}
