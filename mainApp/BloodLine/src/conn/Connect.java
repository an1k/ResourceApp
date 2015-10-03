package conn;
import helper.HelperSqlQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private static HelperSqlQuery query;
	private static Connection con =null;
	public static Connection getCon() throws ClassNotFoundException, SQLException
	{
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
		
		return con;
	}
	

	public static HelperSqlQuery getQuery(){
		return query;
	}
	public static void closeConnection() throws SQLException {
		//log.info("----Connection closed with MYSQL database----");
		con.close();
	}
}