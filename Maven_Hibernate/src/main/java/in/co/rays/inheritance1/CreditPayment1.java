package in.co.rays.inheritance1;

public class CreditPayment1 extends Payment1{

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
