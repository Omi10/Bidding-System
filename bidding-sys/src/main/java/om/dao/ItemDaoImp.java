package om.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
	public void save(Item Item) {
		getSession().save(Item);
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
	public List<Item> getItemsByCategory(int categoryId)
	{
		DetachedCriteria criteria = DetachedCriteria.forClass(Item.class);
		DetachedCriteria categoryCriteria = criteria.createCriteria("category").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); ; //Item class has category object
		categoryCriteria.add(Restrictions.eq("id", categoryId)); //category entity has id field
		Criteria executableCriteria = categoryCriteria.getExecutableCriteria(getSession());
		return executableCriteria.list();
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