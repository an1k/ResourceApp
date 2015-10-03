package controller;

import java.io.IOException;
import java.sql.SQLException;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.FileSystemResource;

import pojo.User;
import dataModelChanges.QueryDao;
import dataModelChanges.QueryDaoPcImpl;

public class UserMain {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException,IOException, Exception {
		// TODO Auto-generated method stub
		System.out.println("hello");
		QueryDao query =new QueryDaoPcImpl();
		User user = null;
		boolean hasInsert;
		//BeanFactory factory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		user= (User) context.getBean("user");
		user.setUsername("Chandrima");
		user.setPswd("abcd");
		user.setPhno(91761);
		user.setAddress("Chennai");
		hasInsert=query.insertData(user);
		if(hasInsert)
			System.out.println("Inserted Successfully!! Well Done");
		System.out.println("Sorry!! Try Again");
	}

}
