package Bean;
import java.io.Serializable;
public class User implements Serializable{
   
	private static final long serialVersionUID = 1l;
	private String userName,email,bankname,ifsccode,mobile,accountnumber,history,password,accounttype;
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public User(String userName, String email, String bankname, String ifsccode, String mobile, String accountnumber,
			String history, String password, double accountbalance) {
		super();
		this.userName = userName;
		this.email = email;
		this.bankname = bankname;
		this.ifsccode = ifsccode;
		this.mobile = mobile;
		this.accountnumber = accountnumber;
		this.history = history;
		this.password = password;
		this.accountbalance = accountbalance;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String string) {
		this.password = string;
	}
	private double accountbalance;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getIfsccode() {
		return ifsccode;
	}
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public double getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
