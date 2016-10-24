package om.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import om.entities.Bid;
import om.entities.Item;

@Repository
@Transactional
public class BidDaoImp implements BidDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	ItemDao itemDao;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Bid Bid) {
		getSession().save(Bid);
	}

	@Override
	public Bid getBid(int bidId) {
		return getSession().get(Bid.class, bidId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bid> getBids() throws JDBCConnectionException {
		return getSession().createQuery("from Bid").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Bid getBidResult(int itemId) throws JDBCConnectionException {

		System.out.println("Reaching");
		//int item
		//Query query = getSession().createQuery("from Item where Item.id=:itemId");
		//In the query string we refer to 
		Item item=itemDao.getItem(itemId);
		//Query query = getSession().createQuery("select b from Bid b join b.item i where i.id=:itemId ");
		Query query1 = getSession().createQuery("select max(bidAmount) from Bid where item.id=:itemId and bid_time<:endTime");
		query1.setParameter("itemId",itemId);
		query1.setParameter("endTime",item.getEndTime());
		int amnt = Integer.parseInt(query1.list().get(0).toString());
		//System.out.println("amnyt" + query1.list().toString());
		System.out.println("amnyt" + amnt);
		
		Query query = getSession().createQuery("from Bid where item.id=:itemId and bid_time<:endTime and bidAmount= :bidAmt");
		query.setParameter("itemId",itemId);
		query.setParameter("endTime",item.getEndTime());
		query.setParameter("bidAmt",amnt);
		//List<Bid> list = (List<Bid>) query.list();
		Bid b = (Bid)query.list().get(0);
		System.out.println("list");
		System.out.println("Bid Id" + b.getId() + "User" + b.getUser().getName());
		System.out.println("list");
		//System.out.println(list);
//		for (Object x : res) {
//			System.out.println(x.g);
//		}
        return null;
	}

	@Override
	public void update(Bid bid) {
		getSession().update(bid);
	}

	@Override
	public void delete(Bid bid) {
		getSession().delete(bid);
	}

}

/*
 * Criteria criteria = getSession().createCriteria(Bid.class); Item
 * item=itemDao.getItem(itemId); //criteria.add(Restrictions.lt("bidTime",
 * item.getEndTime())); Criteria resultCriteria =
 * criteria.createCriteria("item");
 * //.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); // Item class has
 * category object resultCriteria.add(Restrictions.eq("id", itemId)); //
 * category entity // has id field //Item item=itemDao.getItem(itemId);
 * //criteria.createAlias("item", "i");
 * criteria.addOrder(Order.desc("bidAmount"));
 * //System.out.println(item.getEndTime());
 * //criteria.add(Restrictions.lt("bidTime", item.getEndTime()));
 * //criteria.add(Restrictions.lt("i.endTime",item.getEndTime()));
 * //criteria.add(Restrictions.lt("item.", value)) criteria.setMaxResults(1);
 * //return (Bid) resultCriteria.uniqueResult();
 * System.out.println("Object is "+resultCriteria.uniqueResult()); return (Bid)
 * resultCriteria.uniqueResult();
 */
