package dataModelChanges;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import conn.Connect;
//import org.apache.log4j.Logger;
import pojo.User;
import helper.HelperSqlQuery;
//import com.accenture.adf.exceptions.FERSGenericException;


/**
 * @author Chandrima
 *
 */
public class QueryDaoPcImpl implements QueryDao {
	//private static Logger log = Logger.getLogger(QueryDaoPcImpl.class);

	//JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private User bean=null;
	private HelperSqlQuery query;
	
	public QueryDaoPcImpl(){
		//BeanFactory factory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		query=(HelperSqlQuery) context.getBean("query");
		connection=(Connection) context.getBean("connection");
	}
	
	public boolean insertData(User bean) throws ClassNotFoundException,
	SQLException, Exception {
		connection=Connect.getCon();
		statement=connection.prepareStatement(query.getInsertQuery());
		statement.setString(1,bean.getUsername());
		statement.setString(2,bean.getPswd());
		statement.setLong(3,bean.getPhno());
		statement.setString(4,bean.getAddress());
		Connect.closeConnection();
		if(statement.executeUpdate()>0)
			return true;
		return false;
}

	@Override
	public User fetchQuery() throws ClassNotFoundException, SQLException,
			Exception {
		// TODO Auto-generated method stub
		bean=new User();
		
		return null;
	}
	

}
