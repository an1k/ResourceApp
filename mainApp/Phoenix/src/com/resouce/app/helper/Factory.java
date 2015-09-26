package com.resouce.app.helper;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {

	private static ApplicationContext context;
	
	static{
		
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	public static ApplicationContext getContext(){
		return context;
	}
	
	
}
