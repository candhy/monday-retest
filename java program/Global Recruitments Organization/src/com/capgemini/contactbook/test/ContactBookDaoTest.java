package com.capgemini.contactbook.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exception.ContactBookException;


public class ContactBookDaoTest {
 static ContactBookDaoImpl dao=null;
 EnquiryBean enquiryBean=null;
 
@Test
 @Before
 public void intialise() {
	 System.out.println("in before class");
		dao = new ContactBookDaoImpl();
		enquiryBean = new  EnquiryBean();
 }
 
 
 
	@Test
	public void testAddEnquiry() throws ContactBookException {
		enquiryBean.setfName("Dutt");
		enquiryBean.setlName("Sai");
		enquiryBean.setContactNo("9912880822");
     	enquiryBean.setpDomain("BackEnd");
    	enquiryBean.setpLocation("Bang");
		assertEquals(1008,dao.addEnquiry(enquiryBean));
	}
	
	@Test
	public void testViewEnquiry() throws ContactBookException {
		
		assertEquals("Hanuman",dao.getEnquiryDetails(1004).getfName());
	}


}
