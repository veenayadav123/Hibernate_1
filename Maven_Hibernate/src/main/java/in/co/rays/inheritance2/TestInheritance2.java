package in.co.rays.inheritance2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.co.rays.inheritance1.CashPayment1;
import in.co.rays.inheritance1.ChequePayment1;
import in.co.rays.inheritance1.CreditPayment1;

public class TestInheritance2 {

public static void main(String[] args) {
		
		testTablePerSubclassDis(); //Table Per subclass,using a discriminator
	}

	private static void testTablePerSubclassDis() {
	
		 CreditPayment2 cp = new CreditPayment2(); 
		  cp.setPaymentId(10);
		  cp.setAmount(25000);
		  cp.setCcType("visa");
		  cp.setPaymentType("credit");
		 
		ChequePayment2 chq = new ChequePayment2();
		chq.setPaymentId(11);
	    chq.setAmount(30000);
		chq.setBankName("BOI");
		chq.setChqNumber("25987455");
		chq.setPaymentType("cash");
	

		
		  CashPayment2 cs = new CashPayment2(); 
		  cs.setPaymentId(12);
		  cs.setAmount(30000); 
		  cs.setPaymentType("Cash");
		 
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
