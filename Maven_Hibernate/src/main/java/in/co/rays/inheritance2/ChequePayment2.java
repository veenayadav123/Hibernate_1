package in.co.rays.inheritance2;

public class ChequePayment2 extends Payment2{

	private long paymentId;
	private String chqNumber;
	private String bankName;
	
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getChqNumber() {
		return chqNumber;
	}
	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
