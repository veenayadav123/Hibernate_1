package in.co.rays.inheritance1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.inheritance.CashPayment;
import in.co.rays.inheritance.ChequePayment;
import in.co.rays.inheritance.CreditCardPayment;

public class TestInheritance1 {

	public static void main(String[] args) {
		
		testTablePerSubclass();
	}

	private static void testTablePerSubclass() {
	
		 CreditPayment1 cp = new CreditPayment1(); 
		  cp.setPaymentId(1);
		  cp.setAmount(15000); 
		  cp.setCcType("visa");
		  
		 
		ChequePayment1 chq = new ChequePayment1();
		chq.setPaymentId(2);;
		chq.setAmount(25000);
		chq.setBankName("BOI");
		chq.setChqNumber("25987455");

		CashPayment1 cs = new CashPayment1();
		cs.setPaymentId(3);
		cs.setAmount(30000);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

	    s.save(cp);
		s.save(chq);
		s.save(cs);
		t.commit();
		s.close();
		System.out.println("added");


		
	}
	
}
