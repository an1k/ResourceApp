package com.resource.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.resource.app.helper.Factory;
import com.resource.app.helper.ResourceDataConnection;
import com.resource.app.helper.ResourceDbQuery;
import com.resource.app.pojo.User;

public class MainDAO {

	
	private Connection con;
	private PreparedStatement statement;
	private ResourceDbQuery query;
	public MainDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		ResourceDataConnection dataConnection=new Factory().getDataConnection();
		this.con=dataConnection.getConnection();
		this.query=dataConnection.getQuery();
		
	}
	
	public synchronized boolean insertData(User bean) throws SQLException  {
		
		statement=con.prepareStatement(query.getInsertQuery());
		statement.setString(1,bean.getUsername());
		statement.setString(2,bean.getPswd());
		statement.setLong(3,bean.getPhno());
		statement.setString(4,bean.getAddress());
		statement.close();
		if(statement.executeUpdate()>0)
			return true;
		return false;
	}
	
}
