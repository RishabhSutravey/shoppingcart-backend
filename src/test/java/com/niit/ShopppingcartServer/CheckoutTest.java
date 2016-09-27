package com.niit.ShopppingcartServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CheckoutDAO;
import com.niit.shoppingcart.model.Checkout;

public class CheckoutTest {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		CheckoutDAO checkoutDAO = (CheckoutDAO) context.getBean("checkoutDAO");
		Checkout checkout = (Checkout) context.getBean("checkout");

		//ca.setId(154);
		checkout.setCartid(12);
		checkout.setAddress("laptop ");
checkout.setStatus("798");
checkout.setUserid(435);

		if (checkoutDAO.saveOrUpdate(checkout) == true) {
			System.out.println("cart created successfully");
		} else {
			System.out.println("not able to create cart");
		}

	}
}
