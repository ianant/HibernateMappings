package com.udemy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetails;
import com.udemy.hibernate.entity.Review;

public class CourseReviewDemo {

	public static void main(String[] args) {
		
		SessionFactory fact=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session ses=fact.getCurrentSession();
		
		try {
			
			Course theCourse=new Course("Java Programming");
			
			ses.beginTransaction();
			
			theCourse.add(new Review("Exellent course"));
			theCourse.add(new Review("Worse course of my life"));
			theCourse.add(new Review("Ok Ok"));
			
			ses.save(theCourse); 	
			
			ses.getTransaction().commit();
		}
		finally {
			
			ses.close();
			fact.close();
			
		}

	}

}
