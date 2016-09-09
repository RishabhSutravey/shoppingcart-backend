package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;
@Repository
public interface SupplierDAO {

public boolean saveOrUpdate(Supplier supplier);
public boolean delete(Supplier supplier);
public  Supplier get(int supplier);
public  List<Supplier> list();
	
	
}
