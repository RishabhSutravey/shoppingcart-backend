package com.niit.ShopppingcartServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.model.Cart;

public class CartTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		CartDAO cartDAO = (CartDAO) context.getBean("cartDAO");
		Cart cart = (Cart) context.getBean("cart");

		cart.setId(154);
		/*cart.setProductid(12);
		cart.setProductname("laptop ");
cart.setPrice(798);*/
cart.setUserid(435);
cart.setQuantity(3);
		if (cartDAO.update(cart) == true) {
			System.out.println("cart created successfully");
		} else {
			System.out.println("not able to create cart");
		}

	}
}
