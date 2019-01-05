package com.capgemini.contactbook.dao;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;

public interface ContactBookDao {
   public int addEnquiry(EnquiryBean enqry)throws ContactBookException;
   public EnquiryBean getEnquiryDetails(int enquiryID)throws ContactBookException;
}
