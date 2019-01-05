package com.capgemini.salesmanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;
import com.capgemini.salesmanagement.exception.ProductException;

public class ProductService implements IProductService{
			
	ProductDAO productDAO=new IProductDAO();
	
	@Override
	public ProductBean getProductDetails(int productCode) throws Exception {
		ProductBean productBean=new ProductBean();
		productBean=productDAO.getProductDetails(productCode);
		return productBean;
	
	}

	@Override
	public boolean insertSalesDetails(ProductBean productBean) throws Exception {
		
		productDAO.insertSalesDetails(productBean);
		
		return true;
	}

		
		
}
