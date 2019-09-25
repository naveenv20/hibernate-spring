package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			//create course
			Course tempcourse=new Course("Pac Man");
			System.out.println("Save for Course");
			session.save(tempcourse);	
			
			//create students
			Student temp1=new Student("sai","ram","s_r@gmail.com");
			Student temp2=new Student("sai","krishna","s_k@gmail.com");
			Student temp3=new Student("sai","murali","s_m@gmail.com");
			//add students to course
			tempcourse.addstudent(temp1);
			tempcourse.addstudent(temp2);
			tempcourse.addstudent(temp3);
			  
			//save the students
			System.out.println("Saving students");
			session.save(temp1);
			session.save(temp2);
			session.save(temp3);
			
			System.out.println("Total stud : ->"+tempcourse.getStudents());
			
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





