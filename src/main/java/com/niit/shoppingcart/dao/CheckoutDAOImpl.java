package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Checkout;

@SuppressWarnings("deprecation")
@Repository(value="checkoutDAO")
public class CheckoutDAOImpl implements CheckoutDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public CheckoutDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Checkout checkout) {
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(checkout);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
	}

	@Transactional
	public boolean delete(Checkout checkout) {
			try {
				sessionFactory.getCurrentSession().delete(checkout);
				return true;
			} catch (Exception e) {
				
				e.printStackTrace();
				return false;
			}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Transactional
	public List<Checkout> list() {
		String hql ="from Checkout";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Transactional
	public Checkout get(int id) {
		String hql = "from Checkout where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Checkout>list= query.list();
		
		if(list.isEmpty())
		{
			
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

}
