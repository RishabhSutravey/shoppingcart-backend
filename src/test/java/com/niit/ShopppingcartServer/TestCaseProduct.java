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
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");

	}

	@Test
	public void deleteProductTestCase() {

		product.setId(213);
		boolean flag = productDAO.delete(product);
		assertEquals("deleteProductTestCase ", flag, true);
	}

	@Test
	public void addProductTestCase() {
		product.setId(1232);
		product.setName("iphone");
		product.setDescription("this is iphone");
		product.setPrice(6000);

		assertEquals("addProductTestCase", productDAO.saveOrUpdate(product), true);
	}

	@Test
	public void listProductTestCase() {
		assertEquals("listProductTestCase", productDAO.list().size(), 7);
	}

	@Test
	public void updateProductTestCase() {
		product.setId(1231);
		product.setName("sams");
		product.setDescription("this is samsung");
		product.setPrice(5432);
		assertEquals("updateProductTestCase", productDAO.saveOrUpdate(product), true);
	}

	@Test
	public void getProductTestCase() {
		assertEquals("getProductTestCase", productDAO.get(123), null);
	}
}
