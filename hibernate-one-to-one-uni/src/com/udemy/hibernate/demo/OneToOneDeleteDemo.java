package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetails;

public class OneToOneDeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetails.class).
				addAnnotatedClass(Instructor.class).
				buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=4;
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			Instructor currentIns=session.get(Instructor.class, id);
			
			
			
			System.out.println("deleting the transaction" + currentIns);
			
			if(currentIns!=null) {
			
			session.delete(currentIns);
			
			}
			
			else {
				System.out.println("Id is not present to delete");
			}
			session.getTransaction().commit();
			
			System.out.println("Done:::");
		}
		finally {
			factory.close();
		}
				

	}

}
