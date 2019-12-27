package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetails;

public class CreateCourseDemo {

	public static void main(String[] args) {
		
		SessionFactory fact=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session ses=fact.getCurrentSession();
		
		try {
			
			int theID=1;
			
			
			
			ses.beginTransaction();
			
			Instructor ins=ses.get(Instructor.class, theID);
			
			Course course1=new Course("Core Java Technologies");
			
			Course course2=new Course("Spring Frameworks");
			
			ins.add(course1);
			
			ins.add(course2);
			
			ses.save(course1);
			
			ses.save(course2);
			
			ses.getTransaction().commit();
		}
		finally {
			
			ses.close();
			fact.close();
			
		}

	}

}
