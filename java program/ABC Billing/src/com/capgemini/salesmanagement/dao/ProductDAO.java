package com.capgemini.salesmanagement.dao;

import com.capgemini.salesmanagement.bean.ProductBean;

public interface ProductDAO {

	
	ProductBean getProductDetails(int productCode) throws Exception;
	boolean insertSalesDetails(ProductBean productBean) throws Exception;
}
