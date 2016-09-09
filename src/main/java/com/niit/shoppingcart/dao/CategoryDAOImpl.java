package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Repository(value="categoryDAO")
@SuppressWarnings("deprecation")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Category category){
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Category category){
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Category get(int id){
		
		String hql = "from Category where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Category>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public  List<Category> list(){
		
		String hql ="from Category";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
		
	
}
