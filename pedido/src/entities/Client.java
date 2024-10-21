package entities;

import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date birth_date;
	public Client() {
		
	}
	public Client(String name, String email, Date birth_date) {
		this.name = name;
		this.email = email;
		this.birth_date = birth_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	
	
	
}
