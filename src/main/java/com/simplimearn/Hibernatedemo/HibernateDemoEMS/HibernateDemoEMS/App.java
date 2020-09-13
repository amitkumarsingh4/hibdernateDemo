package com.simplimearn.Hibernatedemo.HibernateDemoEMS.HibernateDemoEMS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplimearn.Hibernatedemo.HibernateDemoEMS.HibernateDemoEMS.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	
    	//1.load configuration
    	StandardServiceRegistry sService = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata meta = new MetadataSources(sService).getMetadataBuilder().build();
    	
    	SessionFactory factory = meta.getSessionFactoryBuilder().build();
    	// Step2
    	Session session =factory.openSession();
    	// step3
    	Transaction trans = session.beginTransaction();
    	
    	Employee emp = new Employee();
    	emp.setEmpId(100);
    	emp.setEmpName("John Smith");
    	emp.setSalary(10000);
    	emp.setDepartment("Engineering");
    	
    	session.save(emp);
    	
    	trans.commit();
    	
    	factory.close();
    	session.close();
    	
    	
    	
    }
}
