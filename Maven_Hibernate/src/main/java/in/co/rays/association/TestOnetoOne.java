package in.co.rays.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOnetoOne {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setFirstName("Veena");
		emp.setLastName("Yadav");

		Address adr = new Address();
		adr.setCity("Indore");
		adr.setStreet("xyz");
		adr.setState("MP");

		emp.setEmpAdd(adr);
		adr.setEmp(emp);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.save(emp);
		s.save(adr);
		tx.commit();
		s.close();
		
		System.out.println("added");

	}
}
