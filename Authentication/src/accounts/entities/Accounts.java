package accounts.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Accounts {

	@Id
	private String username;
	private String password;
	private String fname;
	private String lname;
	
	public Accounts() {
	
	}

	public Accounts(String username, String password, String fname, String lname) {
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
