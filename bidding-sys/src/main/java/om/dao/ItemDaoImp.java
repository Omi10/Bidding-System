package om.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import om.entities.Item;


/**
 * DAO Implementation that performs CRUD operations on Item Entity
 * 
 * @author omprakash
 *
 */

@Repository
@Transactional
public class ItemDaoImp implements ItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int save(Item Item) {
		getSession().save(Item);
		return Item.getId();
	}

	@Override
	public Item getItem(int ItemId) {
		return getSession().get(Item.class, ItemId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getItems() throws JDBCConnectionException {
		return getSession().createQuery("from Item").list();
	}

	@Override
	public void update(Item Item) {
		getSession().update(Item);
	}

	@Override
	public void delete(Item Item) {
		getSession().delete(Item);
	}

}