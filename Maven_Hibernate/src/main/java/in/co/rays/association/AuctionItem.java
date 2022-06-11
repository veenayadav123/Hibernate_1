package in.co.rays.association;

import java.util.Set;

public class AuctionItem {
	private int id;
	private String description;
	private Set<Bid> bid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Bid> getBid() {
		return bid;
	}

	public void setBid(Set<Bid> bid) {
		this.bid = bid;
	}

	
	
	

}
