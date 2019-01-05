package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.management.Query;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.util.DBConnection;

public class IProductDAO implements ProductDAO{

	
	
	@Override
	public ProductBean getProductDetails(int productCode) throws Exception {
		
		Connection connection=DBConnection.getConnection();
		ProductBean productBean=new ProductBean();
		try
	
		{
			int pCode=0;
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(QueryMapper.PRODUCT_CODE);
			while(resultSet.next())
			{
					 pCode=resultSet.getInt(1);
					 System.out.println();
					 if(productCode==pCode)
					 {
						 pCode=productCode;
						 break;
					 }
					 pCode=0;
			}
					if(productCode==pCode)
					{
			PreparedStatement prepareStatement=connection.prepareStatement(QueryMapper.PRODUCT_DETAILS);
			prepareStatement.setInt(1,productCode);
			ResultSet resultSet1=prepareStatement.executeQuery();
			while(resultSet1.next())
			{
				productBean.setProductID(resultSet1.getInt(1));
				productBean.setProductName(resultSet1.getString(2));
				productBean.setProductCategory(resultSet1.getString(3));
				productBean.setProductDescription(resultSet1.getString(4));
				productBean.setProductPrice(resultSet1.getInt(5));
				
			}
			
					}else {
						
						return null;
					}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
			
			
		return productBean;		
	}

	@Override
	public boolean insertSalesDetails(ProductBean productBean) throws Exception {
		 
		
		Connection connection=DBConnection.getConnection();
		
		try
		{
			int quantity=productBean.getQuantity();
			long total=productBean.getProductPrice()*quantity;
			productBean.setLineTotal(total);
			PreparedStatement prepareStatement=connection.prepareStatement(QueryMapper.INSERT_SALE);
			prepareStatement.setInt(1,productBean.getProductID());
			prepareStatement.setInt(2, quantity);
			prepareStatement.setLong(3,total);
			prepareStatement.executeUpdate();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
				
	return true;
	}

}
