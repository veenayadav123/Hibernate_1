package in.co.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.CacheDTO;
import in.co.rays.bean.UserBean;

public class TestCache {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testGet();
		// testEvict(); //first level Cache single obj remove
		// testClear(); //first level Cache All obj remove
		// testClose(); //first level Cache 1record get & 2nd Exception session closed
		testClose1();// Second level Cache
	}

	private static void testClose1() throws Exception {

		//CacheDTO u = new CacheDTO();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		 CacheDTO u = (CacheDTO) s.get(CacheDTO.class, 1);
		// u = (UserBean) s.load(UserBean.class, 5);

		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());
		
		s.close();
		Session s1 = sf.openSession();
		CacheDTO ct= (CacheDTO) s1.get(CacheDTO.class, 1);
		System.out.print(ct.getId());
		System.out.print("\t" + ct.getfName());
		System.out.print("\t" + ct.getlName());
		System.out.print("\t" + ct.getUserName());
		System.out.println("\t" + ct.getPassword());

		s1.close();

	}

	private static void testClose() {

		CacheDTO u = new CacheDTO();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		u = (CacheDTO) s.get(CacheDTO.class, 1);
		// u = (UserBean) s.load(UserBean.class, 5);

		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.close();

		u = (CacheDTO) s.get(CacheDTO.class, 2);
		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.close();

	}

	private static void testClear() {

		CacheDTO u = new CacheDTO();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		u = (CacheDTO) s.get(CacheDTO.class, 1);
		// u = (UserBean) s.load(UserBean.class, 5);

		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.clear();

		u = (CacheDTO) s.get(CacheDTO.class, 2);
		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.close();

	}

	private static void testEvict() {

		CacheDTO u = new CacheDTO();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		u = (CacheDTO) s.get(CacheDTO.class, 1);
		// u = (UserBean) s.load(UserBean.class, 5);

		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.evict(u);

		u = (CacheDTO) s.get(CacheDTO.class, 2);
		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.close();

	}

	private static void testGet() {

		CacheDTO u = new CacheDTO();

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		u = (CacheDTO) s.get(CacheDTO.class, 1);
		// u = (UserBean) s.load(UserBean.class, 5);

		System.out.print(u.getId());
		System.out.print("\t" + u.getfName());
		System.out.print("\t" + u.getlName());
		System.out.print("\t" + u.getUserName());
		System.out.println("\t" + u.getPassword());

		s.close();

	}

	private static void testAdd() {

		CacheDTO u = new CacheDTO();

		u.setfName("Veer");
		u.setlName("Yadav");
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
}
