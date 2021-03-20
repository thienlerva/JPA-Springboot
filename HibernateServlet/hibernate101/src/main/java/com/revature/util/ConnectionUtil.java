package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtil {
	
	//this class wil use the Configuration interface to create a Singleton instance
	//of a Sessionfactory.
	
	private static ConnectionUtil cu;
	private SessionFactory sessionFactory;
	
	public synchronized static ConnectionUtil getInstance() {
		if(cu==null) {
			cu = new ConnectionUtil();
		}
		return cu;
	}
	
	//ConnectionUtil.getInstance.getSession
	private synchronized SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			//get config details from hibernate.cfg.xml
			Configuration hibConfiguration = new Configuration().configure();
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(hibConfiguration.getProperties()).buildServiceRegistry();
		
			sessionFactory = hibConfiguration.buildSessionFactory(serviceRegistry);
			
		}
		return sessionFactory;
	}
	
	// return session from sessionFactory
	public Session getSession() {
		return this.getSessionFactory().openSession();
	}

}
