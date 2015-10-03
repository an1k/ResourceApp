package com.resource.app.DAO;

import java.sql.SQLException;

import com.resource.app.pojo.User;


public interface QueryDao {
	

	public boolean insertData(User bean)throws ClassNotFoundException,
	SQLException, Exception ;
	
	public User fetchQuery() throws ClassNotFoundException,
	SQLException, Exception ;

}


