package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetails;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		SessionFactory fact=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session ses=fact.getCurrentSession();
		
		try {
			
			Instructor ins=new Instructor("Anant","Tripathi","anant@gmail.com");
			
			InstructorDetails insDetails=new InstructorDetails("anant/youtube","Runnung");
			
			ins.setInstructorDetails(insDetails);
			
			ses.beginTransaction();
			
			ses.save(ins);
			
			ses.getTransaction().commit();
		}
		finally {
			
			ses.close();
			fact.close();
			
		}

	}

}
