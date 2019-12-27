package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetails;

public class OneToOneInsertDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetails.class).
				addAnnotatedClass(Instructor.class).
				buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			/*
			 * Instructor ins=new Instructor("Anant","Tripathi","anant@gmail.com");
			 * InstructorDetails insDetail=new
			 * InstructorDetails("youtube.com/anant","coding");
			 */
			
			Instructor ins=new Instructor("Ashu","Panwar","Ashu@gmail.com");
			InstructorDetails insDetail=new InstructorDetails("youtube.com/ashu","Paise Udana");
			ins.setInstructorDetails(insDetail);
			
			session.beginTransaction();
			
			System.out.println("saving the transaction" + ins);
			
			session.save(ins);
			
			session.getTransaction().commit();
			
			System.out.println("Done:::");
		}
		finally {
			factory.close();
		}
				

	}

}
