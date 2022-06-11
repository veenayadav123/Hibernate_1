package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.UserBean;

public class TestJoins {

	public static void main(String[] args) {

		//testLike();
		testAdd();
		//testLeftJoins();
	}
	public static void testAdd() {

		UserBean u = new UserBean();

		u.setFname("Veena");
		u.setLname("Yadav");
		u.setUserName("@yadav");
		u.setPassword("vyadav123");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		s.save(u);
		t.commit();
		s.close();
		System.out.println("added");

	}


	public static void testLike() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("from UserBean where fname like 'V%'");// class name HQL Query

		List li = q.list();
		Iterator it = li.iterator();

		while (it.hasNext()) {

			UserBean u = (UserBean) it.next();
			System.out.println(u.getFname());
		}
		s.close();
	}
	
	public static void testLeftJoins() {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("select ");// class name HQL Query

	}
	

}
