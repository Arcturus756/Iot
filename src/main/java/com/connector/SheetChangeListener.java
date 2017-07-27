package com.connector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SheetChangeListener implements ServletContextListener  {

	public void contextInitialized(ServletContextEvent sce) {
		 Thread thread = new Thread(new SheetService());
	        thread.start();
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
