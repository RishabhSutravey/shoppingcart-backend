package com.niit.ShopppingcartServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		UserDetails userDetails = (UserDetails) context.getBean("userDetails");

		userDetails.setId(21);
		userDetails.setUsername("rish");
		userDetails.setPassword("rishabh");
		userDetails.setMail("xyz123@ymail.com");
		userDetails.setContact("123456789");
		userDetails.setAddress("hyderabad");
		userDetails.setEnabled(true);

		if (userDetailsDAO.saveOrUpdate(userDetails) == true) {
			System.out.println("userDetails created successfully");
		} else {
			System.out.println("not able to create userDetails");
		}

	}
}
