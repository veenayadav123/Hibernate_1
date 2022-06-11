package in.co.rays.association;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//One to Many Association
public class TestAuctionBid {
	public static void main(String[] args) {
		AuctionItem item = new AuctionItem();
		item.setDescription("audi");
		Bid bid1 = new Bid();
		bid1.setAmount(100);

		Set<Bid> set = new HashSet<Bid>();
		set.add(bid1);

		item.setBid(set);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();

		s.save(item);

		tx.commit();
		s.close();
		System.out.println("inserted");

	}

}
