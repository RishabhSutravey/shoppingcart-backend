package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@Repository(value="productDAO")
@SuppressWarnings("deprecation")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Product product){
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Product product){
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Product product){
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Product get(String id){
		
		String hql = "from Product where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Product>list= query.list();
		
		if(list==null||list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<Product> list(){
		
		String hql ="from Product";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
		
	
}
