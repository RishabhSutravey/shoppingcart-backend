package com.niit.ShopppingcartServer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
	
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		productDAO =(ProductDAO) context.getBean("productDAO");
		product=(Product) context.getBean("product");
	
	}

	@Test
	public void deleteProductTestCase(){
		
		product.setId("PD001");
		boolean flag=productDAO.delete(product);
        assertEquals("deleteProductTestCase ", flag, true);	
	}
@Test
public void addProductTestCase(){
	product.setId("MOB003");
	product.setName("iphone");
	product.setDescription("this is iphone");
	product.setPrice(6000);
productDAO.save(product);
assertEquals("addProductTestCase",productDAO.save(product),true);
}
@Test
public void listProductTestCase(){
	assertEquals("listProductTestCase",productDAO.list().size(),4);
}
@Test
public void updateProductTestCase(){
	product.setId("MOB004");
	product.setPrice(5432);
	assertEquals("updateProductTestCase",productDAO.update(product),false);
}
@Test
public void getProductTestCase(){
	assertEquals("getProductTestCase",productDAO.get("MOB004"),null);
}
}
