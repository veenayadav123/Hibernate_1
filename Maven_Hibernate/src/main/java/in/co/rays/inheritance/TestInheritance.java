package in.co.rays.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.bean.CacheDTO;

public class TestInheritance {

	public static void main(String[] args) {

		testTablePerclassHierarchy();
	}

	private static void testTablePerclassHierarchy() {

		
		  CreditCardPayment ccp = new CreditCardPayment(); 
		  ccp.setId(1);
		  ccp.setAmount(20000);
		  ccp.setPaymentType("credit"); 
		  ccp.setCcType("visa");
		  
		 
		ChequePayment chq = new ChequePayment();
		chq.setId(2);
		chq.setAmount(15000f);
		chq.setChqNumber("2598745");
		chq.setBankName("BOI");
		chq.setPaymentType("VISA");

		CashPayment cs = new CashPayment();
		cs.setId(3);
		cs.setAmount(30000f);
		cs.setPaymentType("cash");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

	    s.save(ccp);
		s.save(chq);
		s.save(cs);
		t.commit();
		s.close();
		System.out.println("added");

	}
}
