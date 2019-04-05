package br.com.agespisa.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContext implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
       HibernateUtil.getSessionFactory().close();
	}
	
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory();
		
	}

}
