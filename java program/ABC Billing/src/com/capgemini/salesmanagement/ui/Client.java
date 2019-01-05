package com.capgemini.salesmanagement.ui;

import java.util.Scanner;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.exception.ProductException;
import com.capgemini.salesmanagement.service.ProductService;

public class Client {
		static ProductService productService=null;
		static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws Exception {
	
		while(true)
		{
			System.out.println("ABC BILLING SYSTEM");
			System.out.println("__________________");
			System.out.println("1.Genarate Bill");
			System.out.println("2.Exit");
			int option=scanner.nextInt();
			switch(option)
			{
			case 1:
				try
				{
					ProductBean productBean=new ProductBean();
				ProductService productService=new ProductService();
				System.out.println("Enter the Product Code :");
				productBean.setProductID(scanner.nextInt());
				productBean=productService.getProductDetails(productBean.getProductID());
				if(productBean!=null) {
				System.out.println(productBean.getProductID()+" "+productBean.getProductName()+" "+productBean.getProductCategory()+" "+productBean.getProductDescription()+" "+productBean.getProductPrice());
				}
				else
				{
					System.out.println("enter valid ID!");
				}
				System.out.println("Enter the Quantity :");
				int quantity=scanner.nextInt();
				if(quantity>0)
				{
				productBean.setQuantity(quantity);
				}
				else
				{
					System.out.println("enter a valid number");
					quantity=scanner.nextInt();
				}
				productService.insertSalesDetails(productBean);
				
				
				System.out.println("Product Name         :"+productBean.getProductName());
				System.out.println("Prodcut Categry      :"+productBean.getProductCategory());
				System.out.println("Product Descrpiotn   :"+productBean.getProductDescription());
				System.out.println("Product price  		 :"+productBean.getProductPrice());
				System.out.println("Quantity 	  		 :"+productBean.getQuantity());
				System.out.println("Line TOtal           :"+productBean.getLineTotal());
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				break;
			case 2:
			System.exit(0);
			
			}
		}
		
		

	}

	
	
	
}
