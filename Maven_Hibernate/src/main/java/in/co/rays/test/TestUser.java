package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.UserBean;

public class TestUser {

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		// testList();
		// testSingleColumn();
		// testMultiColumn();
		// testMerge();
		// testObjState1();//Transient State (Data Temporary Store Only RAM Memory)
		// testObjState2();//Persistent State (Data Available in Database & Session )
		// testObjState3();//Detached State (Data Available in Only Database )
	}

	private static void testObjState3() {

		UserBean u = new UserBean();

		u.setFname("Ishita");
		u.setLname("Sharma");
		u.setUserName("@sharma");
		u.setPassword("Isharma@123");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		s.save(u);
		t.commit();
		s.close();
		System.out.println("Detached State");

	}

	private static void testObjState2() {

		UserBean u = new UserBean();

		u.setFname("Ishita");
		u.setLname("Sharma");
		u.setUserName("@sharma");
		u.setPassword("Isharma@123");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		s.save(u);
		t.commit();
		// s.close();
		System.out.println("Persistent State");

	}

	private static void testObjState1() {

		UserBean u = new UserBean();
		u.setId(4);

		u.setFname("Ishita");
		u.setLname("Sharma");
		u.setUserName("@sharma");
		u.setPassword("Isharma@123");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		s.delete(u);
		t.commit();
		s.close();
		System.out.println("Transient State");

	}

	private static void testMerge() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		UserBean u = (UserBean) s.get(UserBean.class, 1);
		System.out.print("\t" + u.getFname());
		s.close();
		u.setFname("Ananya");

		Session s1 = sf.openSession();
		UserBean u1 = (UserBean) s1.get(UserBean.class, 1);
		Transaction t = s1.beginTransaction();
		// s1.update(u);
		s1.merge(u);
		System.out.println("    updated");
		t.commit();
		// s.close();

	}

	public static void testAdd() {

		UserBean u = new UserBean();

		u.setFname("Veer");
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

	public static void testUpdate() {

		UserBean u = new UserBean();

		u.setId(5);
		u.setFname("Enaya");
		u.setLname("Shah");
		u.setUserName("@shah");
		u.setPassword("Eshah123");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		s.update(u);

		t.commit();
		s.close();
		System.out.println("Updated");

	}

	public static void testDelete() {

		UserBean u = new UserBean();
		u.setId(4);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		s.delete(u);
		t.commit();
		s.close();
		System.out.println("Deleted");

	}

	public static void testGet() {

		UserBean u = new UserBean();
		u.setId(5);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		u = (UserBean) s.get(UserBean.class, 1);
		// u = (UserBean) s.load(UserBean.class, 5);

		System.out.print(u.getId());
		System.out.print("\t" + u.getFname());
		System.out.print("\t" + u.getLname());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.close();
	}

	public static void testList() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("from UserBean");// class name HQL Query

		List<UserBean> li = q.list();
		Iterator<UserBean> it = li.iterator();

		while (it.hasNext()) {
			UserBean u = (UserBean) it.next();
			System.out.print("\t" + u.getId());
			System.out.print("\t" + u.getFname());
			System.out.print("\t" + u.getLname());
			System.out.print("\t" + u.getUserName());
			System.out.println(u.getPassword());

		}
		s.close();
	}

	public static void testSingleColumn() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("Select u.fname from UserBean u");// class name HQL Query

		List li = q.list();
		Iterator it = li.iterator();

		while (it.hasNext()) {

			String us = (String) it.next();
			System.out.println(us);
			// int i = (Integer) it.next();
			// System.out.println(i);

		}
		s.close();
	}

	public static void testMultiColumn() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Query q = s.createQuery("Select u.id,u.fname,u.lname from UserBean u");// class name HQL Query

		List li = q.list();
		Iterator it = li.iterator();

		while (it.hasNext()) {

			Object[] obj = (Object[]) it.next();
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
		s.close();
	}

}
