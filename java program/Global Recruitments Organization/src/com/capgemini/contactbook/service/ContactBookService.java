package com.capgemini.contactbook.service;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;

public interface ContactBookService {
  public int addEnquiry(EnquiryBean enqry)throws ContactBookException;
  public EnquiryBean getEnquiryDetails(int enquiryID)throws ContactBookException;
  public boolean isValidEnquiry(EnquiryBean enqry)throws ContactBookException;
}
