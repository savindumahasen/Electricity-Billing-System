package buisness;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String userName;
	private String password;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstName,String lastName,String accountNumber,String userName,String password) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.accountNumber=accountNumber;
		this.userName=userName;
		this.password=password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

}
