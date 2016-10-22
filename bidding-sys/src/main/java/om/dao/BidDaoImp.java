package om.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import om.entities.Bid;

@Repository
@Transactional
public class BidDaoImp implements BidDao {

	@Autowired
	private SessionFactory sessionFactory;

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
	
		Criteria criteria = getSession().createCriteria(Bid.class);
		Criteria resultCriteria = criteria.createCriteria("item");
				//.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		; // Item class has category object
	    resultCriteria.add(Restrictions.eq("id", itemId)); // category entity																// has id field
	    criteria.addOrder(Order.desc("bidAmount"));
	    criteria.setMaxResults(1);
		return (Bid) resultCriteria.uniqueResult();
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
