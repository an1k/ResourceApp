package com.resource.app.helper;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ResourceDataConnection {

	private Connection connection = null;
	private ResourceDbQuery query;
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*static{
		ApplicationContext context = Factory.getContext();
		query = (ArchieDbQuery) context.getBean("sqlBean");
		DataSource dataSource=(DataSource) context.getBean("dataSource");
		try {
			connection=dataSource.getConnection();
			//log.info("----Connection established with MYSQL database----");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			log.error("error in establishing data connection: "+e.getMessage(), e);
		}
	}*/

	/**
	 * 	<br/>
	 * 	METHOD DESCRIPTION: <br/>
	 *	Open connection to access the underlying database. <br/>
	 *  
	 * 	@throws ClassNotFoundException
	 * 	@throws SQLException
	 * 
	 *  @return Connection
	 * 
	 */
	public Connection getConnection() throws SQLException{
		connection=dataSource.getConnection();
		return connection;
	}

	public ResourceDbQuery getQuery(){
		return query;
	}
	public void closeConnection() throws SQLException {
		//log.info("----Connection closed with MYSQL database----");
		connection.close();
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setQuery(ResourceDbQuery query) {
		this.query = query;
	}

	
	
}
