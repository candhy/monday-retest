package com.capgemini.salesmanagement.bean;

import java.sql.Date;

public class ProductBean {
	
	private String productName;
	private int productID;
	private String productDescription;
	private int quantity;
	private long productPrice;
	private long lineTotal;
	private Date salesDate;
	private String productCategory;
	
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public long getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(long lineTotal) {
		this.lineTotal = lineTotal;
	}
}
