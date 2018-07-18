package com.main.hibernate.AbhiDD;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;






/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	SessionFactory sqlFactory = new Configuration().configure("msql.cfg.xml").buildSessionFactory();
    	Session sqlsession= sqlFactory.openSession();
    	Transaction txmsql = sqlsession.beginTransaction();
    	
    	Employee emp1 = new Employee(1, "ranjeet");
    	
    	sqlsession.save(emp1);
    	sqlsession.flush();
    	txmsql.commit();
    	
    	
    	SessionFactory hqlFactory = new Configuration().configure("hsql.cfg.xml").buildSessionFactory();
    	Session hqlsession= hqlFactory.openSession();
    	Transaction txhsql = hqlsession.beginTransaction();
    	
    	Address1  address1 = new Address1(1, "Bisur");
    	Address1  address2 = new Address1(2, "Budhgaon");
    	
    	hqlsession.save(address1);
    	hqlsession.save(address2);
    	hqlsession.flush();
    	txhsql.commit();
    	
    	
    	List<Employee> employees = sqlsession.createQuery("from Employee").getResultList();
		for (Employee emp : employees) {
			// session.save(new address(student.id, student.name));
			System.out.println(emp.id+" "+emp.name);
		}
		
		List<Address1> addresses = hqlsession.createQuery("from Address1").getResultList();
		for (Address1 add : addresses) {
			// session.save(new address(student.id, student.name));
			System.out.println(add.id+" "+add.address);
		}
    	
		SessionFactory sqlFactory1 = new Configuration().configure("msql.cfg.xml").buildSessionFactory();
    	Session sqlsession1= sqlFactory1.openSession();
    	Transaction txhsql1 = sqlsession1.beginTransaction();
    	
    	for (Employee e1 : employees) {
			for (Address1 a1 : addresses) {
				if (e1.id == a1.id)
					sqlsession1.save(new MetaData(e1.id, e1.name, a1.address));
				

			}

		}
    	
    	
    	sqlsession1.flush();
    	txhsql1.commit();
		
		
		
		
    }
}
