package in.co.rays.inheritance2;

public class CreditPayment2 extends Payment2{

	private long paymentId;
	private String ccType;

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

}
