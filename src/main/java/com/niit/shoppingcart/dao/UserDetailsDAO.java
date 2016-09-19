package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.UserDetails;

@Repository
public interface UserDetailsDAO {

public boolean saveOrUpdate(UserDetails userDetails);
public boolean delete(UserDetails userDetails);
public  UserDetails get(int id);
public  List<UserDetails> list();
public UserDetails isValidUser(int id,String password);
public UserDetails get (String username);
	
	
}
