package com.niit.ShopppingcartServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");

		supplier.setId("SUP001");
		supplier.setName("lot");
		supplier.setAddress("supplier hyderabad");

		if (supplierDAO.save(supplier) == true) {
			System.out.println("supplier created successfully");
		} else {
			System.out.println("not able to create supplier");
		}

	}
}
