package com.niit.ShopppingcartServer;

import java.util.List;

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
List<Supplier>  supplierList= supplierDAO.list();
		/*supplier.setId(133);
		supplier.setName("lot");
		supplier.setAddress("supplier hyderabad");
*/      System.out.printf("supplierlist"+ supplierList);
System.out.println("supid  "+supplier.getId());
		/*if (supplierDAO.update(supplier) == true) {
			System.out.println("supplier deleted successfully");
		} else {
			System.out.println("not able to create supplier");
		}*/

	}
}
