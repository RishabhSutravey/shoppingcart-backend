package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
		
		if(list.isEmpty())
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
	public Cart getproduct(int productid,int userid) {
		String hql="from Cart where productid= "+productid+"and userid="+userid;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart>listproduct=query.list();

		if(listproduct.isEmpty())
		{
			
			return null;
		}
		else
		{
			System.out.println("product");
			return listproduct.get(0);
		}
		
	}
	@Transactional
	public int getsize(int id){
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("userid", id));
		c.setProjection(Projections.count("userid"));
		long count =(long) c.uniqueResult();
		return (int) count;
	}

	@Transactional
	public Cart getusercart(int uid) {
		String hql="from Cart where userid= "+uid;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart>listusercart=query.list();

		if(listusercart.isEmpty())
		{
			return null;
		}
		else
		{
			return listusercart.get(0);
		}
	}

	@Transactional
	public double getprice(int userid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		c.add(Restrictions.eq("userid", userid));
		//c.add(Restrictions.eq("status","C"));
		c.setProjection(Projections.sum("subtotal"));
		double l= (double) c.uniqueResult();
		return l;
	}
	
}
