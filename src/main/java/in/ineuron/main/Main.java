package in.ineuron.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// Inform JVM to activate HIBERNATE
		Configuration configuration = new Configuration();
		configuration.configure();
		
		// Creating a SessionFactory object to hold many other objects required for HIBERNATE
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		// Using SessionFactory object to get only one Session object to perform our persistence operation
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		// Create PERSISTENCE Object
		Student student = new Student();
		student.setSid(1);
		student.setSname("Harsh");
		student.setSaddress("Mumbai");
		student.setSage(20);
		
		// Perform PERSISTENCE operation using Entity/Model/POJO object
		session.save(student);
		
		
		// Commit the operation based on the result
		transaction.commit();
		System.out.println("Object saved to the database...");
		session.close();
		sessionFactory.close();
		
	}

}
