package com.employees_details.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility 
{
	private SessionFactory sessionFactory ;
	private static HibernateUtility hibernateUtility;
    
    private HibernateUtility()
    {
    	try {
    		System.out.println("IN HIBERNATE UTILITY");
    		sessionFactory = new Configuration().configure().buildSessionFactory();
    		//sessionFactory.
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
     
    public static synchronized HibernateUtility getInstance(){
        if(hibernateUtility == null){
        	hibernateUtility = new HibernateUtility();
        }
        
        return hibernateUtility; 
    }
    
    public Session getHibernateSession()
    {
    	return this.sessionFactory.openSession();
    }
    
    public Session OpenSession() {
        return this.sessionFactory.openSession();
    }
    
    public boolean closeSession(Session session)
    {
    	try {
    		session.flush();
    		session.clear();
    		session.close();
    		
    		return true;
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }
}



