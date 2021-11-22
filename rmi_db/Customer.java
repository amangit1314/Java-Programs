package rmi_db;
public class Customer implements java.io.Serializable {
	private int acc_no;
	private String firstname,lastname,email;
	private int amount;

	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int accNo) {
		acc_no = accNo;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
