package com.sms.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JpaUtils {
	
	private static EntityManagerFactory emf = null;
	static {
		emf = Persistence.createEntityManagerFactory("SMSTest");
	}
	
	public static EntityManager createEntityManager(){
		return emf.createEntityManager();
	}
	
	private static SessionFactory configureSessionFactory()    
	        throws HibernateException {    
	    Configuration configuration = new Configuration();    
	    configuration.configure();    
//	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()    
//	            .applySettings(configuration.getProperties())    
//	            .buildServiceRegistry();    
	    return configuration.buildSessionFactory();    
	}

}
