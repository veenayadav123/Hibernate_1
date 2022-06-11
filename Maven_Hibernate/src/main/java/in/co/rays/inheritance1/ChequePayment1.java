package in.co.rays.inheritance1;

public class ChequePayment1 extends Payment1{

	private long paymentId;
	private String ChqNumber;
	private String bankName;
	
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getChqNumber() {
		return ChqNumber;
	}
	public void setChqNumber(String chqNumber) {
		ChqNumber = chqNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
