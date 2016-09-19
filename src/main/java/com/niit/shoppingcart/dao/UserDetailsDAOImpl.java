package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Repository(value="userDetailsDAO")
@SuppressWarnings("deprecation")
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*@Transactional
	public boolean update(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}*/
	@Transactional
	public boolean delete(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  UserDetails get(int id){
		
		String hql = "from UserDetails where id= "+ "'"+ id+"'" ;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails>list= query.list();
		
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
	public UserDetails isValidUser(int id,String password){
		String hql="from UserDetails where id= '" +id+"' and password '" +password+"'"; 
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = query.list();
		if(list==null){
			return null;
		}
		else{
			return list.get(0);
		}
	}
	
	
	@Transactional
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<UserDetails> list(){
		
		String hql ="from UserDetails";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
	}
	@Transactional
	public UserDetails get(String username) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
		c.add(Restrictions.eq("username",username));
		
		@SuppressWarnings("unchecked")
		List<UserDetails> listUser = (List<UserDetails>) c.list();
		
		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}
		else {
			return null;
		}
	
	}
		
	
}
