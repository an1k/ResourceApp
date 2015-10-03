package dataModelChanges;

import java.sql.SQLException;

import pojo.User;


public interface QueryDao {
	

	public boolean insertData(User bean)throws ClassNotFoundException,
	SQLException, Exception ;
	
	public User fetchQuery() throws ClassNotFoundException,
	SQLException, Exception ;

}


