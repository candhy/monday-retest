package com.capgemini.contactbook.dao;

public interface QuerryMapper {
    public static final String QUERY_ADD_DETAILS="insert into enquiry values(enquiryId.nextval,?,?,?,?,?)";
    public static final String QUERY_SELECT_ID="select max(enqryId) from enquiry";
    public static final String QUERY_VIEW_DETAILS="select * from enquiry where enqryId=?";
}
