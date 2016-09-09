package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@Repository(value="productDAO")
@SuppressWarnings("deprecation")
public class ProductDAOImpl implements ProductDAO {
	private static final Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Product product){
		try {
			log.debug("Starting of the method save");
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			log.debug("ending of the method save");
			return true;
		} catch (Exception e) {
			log.error("exception occured in save method"+e.getMessage());
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
	public  Product get(int id){
		
		log.debug("starting of the method get");
		log.info("trying to get product based on id:"+id);
		String hql = "from Product where id= "+ "'"+ id+"'" ;
		log.info("the hsql query is :"+hql);
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
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<Product> list(){
		
		String hql ="from Product";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
		
	
}
