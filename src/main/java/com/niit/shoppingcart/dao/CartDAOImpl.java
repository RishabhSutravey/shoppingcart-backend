package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@SuppressWarnings("deprecation")
@Repository(value="cartDAO")
public class CartDAOImpl implements CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean save(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public boolean delete(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public List<Cart> list() {
		
		String hql ="from Cart";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public Cart get(int id) {
		String hql = "from Cart where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public Cart getproduct(int id) {
		String hql="from Cart where productid= "+id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart>listproduct=query.list();
		//List<Cart> listproduct = (List<Cart>) query.list();
		return listproduct.get(id);
	}
	
}
