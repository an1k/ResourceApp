package com.resource.app.helper;



	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class Factory {

		private static ApplicationContext context;
		
		static{
			
			context=new ClassPathXmlApplicationContext("spring.xml");
			
		}
		
		public static ApplicationContext getContext(){
			return context;
		}
		
		public ResourceDataConnection getDataConnection(){
			return (ResourceDataConnection) context.getBean("resouceDataConnection");
		}
	}

	

