package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddcoursesforkrishnaDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			//get student
			int theID=2;
			Student tempstudent=session.get(Student.class, theID);
			
			System.out.println(tempstudent);
			System.out.println("At start courses are "+ tempstudent.getCourses());
			//create courses
			Course cour1=new Course("Mario");
			Course cour2=new Course("RoadRash");
			
			//add to student to courses
			cour1.addstudent(tempstudent);
			cour2.addstudent(tempstudent);
			//save the courses
			System.out.println("saving courses");
			
			session.save(cour1);
			session.save(cour2);
			
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
			
			
			
			
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





