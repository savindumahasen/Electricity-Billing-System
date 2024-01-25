package buisness;

public class Payment {
	
	private String account;
	private double amount;
	private String email;

	public Payment() {
		// TODO Auto-generated constructor stub
	}
	public Payment(String account,double amount, String email) {
		this.account=account;
		this.amount=amount;
		this.email=email;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}

}
