package com.capgemini.salesmanagement.dao;

public interface QueryMapper {
	
	String PRODUCT_DETAILS="select * from product where product_code=?";
	String PRODUCT_CODE="select product_code from product";
	String INSERT_SALE="insert into sales values(seq_id.nextval,?,?,sysdate,?)";

}
