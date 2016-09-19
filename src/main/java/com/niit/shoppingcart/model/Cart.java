package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
@Id
@GeneratedValue
private int id;
private int productid;
private int userid;
private String productname;
@Column(columnDefinition="int default 1")
private int quantity;
private float price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}


}
