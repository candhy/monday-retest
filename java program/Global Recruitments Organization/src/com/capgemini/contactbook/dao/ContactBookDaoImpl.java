package com.capgemini.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.contactbook.bean.EnquiryBean;
import com.capgemini.contactbook.exception.ContactBookException;
import com.capgemini.contactbook.util.DBConnection;

public class ContactBookDaoImpl implements ContactBookDao {
	static Logger logger = Logger.getRootLogger();
	 static Connection con=null;
	 static PreparedStatement preparedStatement=null;
	 static Statement statement=null;
	 static ResultSet resultSet=null;
	public ContactBookDaoImpl()
	{
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	

	//------------------------ 1.Global Recruitments Organization  --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addEnquiry(EnquiryBean enqry)
	 - Input Parameters	:	EnquiryBean enqry
	 - Return Type		:	int
	 - Throws			:  	ContactBookException
	 - Author			:	RamCharan
	 - Creation Date	:	19/12/2018
	 - Description		:	Adding Enquiry Details
	 ********************************************************************************************************/
	
	

	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		
		con=DBConnection.getConnection();
		try {
			logger.info("inserting details to table");
			 int queryResult=0;
			 preparedStatement=con.prepareStatement(QuerryMapper.QUERY_ADD_DETAILS);
			 preparedStatement.setString(1, enqry.getfName());
			 preparedStatement.setString(2, enqry.getlName());
			 preparedStatement.setString(3, enqry.getContactNo());
			 preparedStatement.setString(4, enqry.getpDomain());
			 preparedStatement.setString(5, enqry.getpLocation());
			queryResult= preparedStatement.executeUpdate();
			 if(queryResult==0) 
				 logger.error("Details not inserted");
			 else
				 logger.info("sucessfully inserted");
			 statement=con.createStatement();
			resultSet=statement.executeQuery(QuerryMapper.QUERY_SELECT_ID);
			if(resultSet.next()) {
				logger.info("displayed Id to user");
				return resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return 0;
	}

	
	
	//------------------------ 1.Global Recruitments Organization --------------------------
	/*******************************************************************************************************
	 - Function Name	:	getEnquiryDetails(int enquiryID)
	 - Input Parameters	:	int enquiryID
	 - Return Type		:	EnquiryBean
	 - Throws			:  	ContactBookException
	 - Author			:	RamCharan
	 - Creation Date	:	19/12/2018
	 - Description		:	Retrieving Enquiry Details
	 ********************************************************************************************************/
	
	
	@Override
	public EnquiryBean getEnquiryDetails(int enquiryID) throws ContactBookException {
		
		con=DBConnection.getConnection();
		      logger.info("Retriving details by Id");
		try {
			EnquiryBean enquiryBean=new EnquiryBean();
			preparedStatement=con.prepareStatement(QuerryMapper.QUERY_VIEW_DETAILS);
		
			preparedStatement.setInt(1, enquiryID);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			logger.info("sucessfully displayed details of user");
				enquiryBean.setEnqryId(resultSet.getInt(1));
				enquiryBean.setfName(resultSet.getString(2));		
				enquiryBean.setlName(resultSet.getString(3));
				enquiryBean.setContactNo(resultSet.getString(4));
				enquiryBean.setpDomain(resultSet.getString(5));
				enquiryBean.setpLocation(resultSet.getString(6));
			    return enquiryBean;
			
			
			}
			if(!resultSet.next()) {
				logger.error("Failed to retrieve");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
