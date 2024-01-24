package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class SaveApp {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, 18);
			if(session != null) {
				transaction = session.beginTransaction();
			}
			if(transaction != null) {
				if(student != null) {
					System.out.println(student);
					student.setSaddress("RCB");
					session.update(student);
					flag = true;
				}	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Record updated successfully");
			} else {
				transaction.rollback();
				System.out.println("Record not found");
			}
			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}
	}
}
