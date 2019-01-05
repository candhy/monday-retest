package com.capgemini.contactbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.exception.ContactBookException;


public class ContactBookServiceImpl implements ContactBookService {
        static ContactBookDao contactBookDao=null;
        static ContactBookDaoImpl contactBookDaoImpl=null;
        static EnquiryBean enquiryBean=null;
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		contactBookDao=new ContactBookDaoImpl();
		int id=contactBookDao.addEnquiry(enqry);
		return id;
	}

	@Override
	public EnquiryBean getEnquiryDetails(int enquiryID) throws ContactBookException {
		contactBookDao=new ContactBookDaoImpl();
		enquiryBean=new EnquiryBean();
		enquiryBean=contactBookDao.getEnquiryDetails(enquiryID);
		return enquiryBean;
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException {
		List<String> list = new ArrayList<>();
		boolean result = false;

		if (!validateFirstName(enqry.getfName())) {
			list.add("fname should start with capital letter & it can't be null");
		}
		if (!validateContactNo(enqry.getContactNo())) {
			list.add("phone number should be exactly 10 digits");
		}
		if (!validateLastName(enqry.getlName())) {
			list.add("lname should start with capital letter & it can't be null");
		}
		if(!validatePLocation(enqry.getpLocation())) {
			list.add("pLocation should start with capital letter & it can't be null");
		}
		if(!validatePDomain(enqry.getpDomain())) {
			list.add("pDomain should start with capital letter & it can't be null");
		}

		if (!list.isEmpty()) {
			result = false;
			throw new ContactBookException(list + "");
		} else {
			result = true;
		}
		return result;
	}
	
	private boolean  validatePDomain(String getpDomain) {
		String nameRegEx = "^[A-Z][a-z]*";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(getpDomain);
		return matcher.matches();
		
	}

	private boolean  validatePLocation(String getpLocation) {
		String nameRegEx =  "^[A-Z][a-z]*";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(getpLocation);
		return matcher.matches();
	}

	private boolean  validateLastName(String getlName) {
		String nameRegEx =  "^[A-Z][a-z]*";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(getlName);
		return matcher.matches();
	}

	private boolean validateFirstName(String getfName) {
		String nameRegEx =  "^[A-Z][a-z]*";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(getfName);
		return matcher.matches();
	}


	private boolean validateContactNo(String phoneNumber) {
		String nameRegEx = "^[6-9][0-9]{9}$";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	
	}

	
}
