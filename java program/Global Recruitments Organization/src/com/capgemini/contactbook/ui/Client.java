package com.capgemini.contactbook.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;


public class Client {

	static EnquiryBean enquiryBean = null;
	static ContactBookService contactBookService=null;
	static ContactBookServiceImpl contactBookServiceImpl=null;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
       
		int option = 0;
		int enqryId=0;
		while (true) {
			System.out.println("**********************Global Recruitments***********************");
			System.out.println("1.Entry Enquiry Details");
			System.out.println("2.View Enquiry Details on Id");
			System.out.println("0.Exit");
			System.out.println("***********************************");
			System.out.println("please enter a choice :");
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					while (enquiryBean == null) {
						enquiryBean = populateEnquiryBean();
					}
					try {
						contactBookService = new ContactBookServiceImpl();
						if(contactBookService.isValidEnquiry(enquiryBean)) {
						enqryId = contactBookService.addEnquiry(enquiryBean);
						System.out.println("Thank you "+enquiryBean.getfName()+" "+enquiryBean.getlName()+" your Unique Id is "+enqryId+" we will conatct you shortly");
					    }
						else{
							System.out.println("please Enter valid details again");
						}
					}catch (ContactBookException e) {
						System.out.println("ERROR" + e);
					} finally {
						enqryId = 0;
						contactBookService = null;
						enquiryBean = null;
					}
					break;
				
				case 2:
					System.out.println("enter the Enquiry No :");
					int enquiryId = sc.nextInt();
					
						  contactBookService=new ContactBookServiceImpl();
						  enquiryBean=new EnquiryBean();
						  try {
							enquiryBean=contactBookService.getEnquiryDetails(enquiryId);
							System.out.println(enquiryBean);
							
						} catch (ContactBookException e) {
							
							System.out.println("Sorry no details found !!!");
						}
					
					break;

				case 0:
					System.out.println("Thank you selecting us!!!");
					System.exit(0);
				}
			}

			catch (InputMismatchException e) {

			}
		}
	}

	private static EnquiryBean populateEnquiryBean() {
         Scanner sc=new Scanner(System.in);
           enquiryBean=new EnquiryBean();
		
           System.out.println("Enter the first name: ");
		    String fName=sc.next();
		    enquiryBean.setfName(fName);
        
		    System.out.println("Enter Last Name :");
		    String lName=sc.next();
		    enquiryBean.setlName(lName);
		    
		    System.out.println("Enter Contact Number :");
		    try {
		         String contactNumber=sc.next();
		         enquiryBean.setContactNo(contactNumber);
		         }
		         catch(InputMismatchException e) {
		        	 sc.next();
		        	 System.err.println("enter only numeric values");
		         }
		   
		    System.out.println("Enter Preferred Domain :");
		    String pLocation=sc.next();
		    enquiryBean.setpLocation(pLocation);
		    
		    System.out.println("Enter the Preferred Location :");
		    String pDomain=sc.next();
		    enquiryBean.setpDomain(pDomain);
		
		    return enquiryBean;
	}
}
