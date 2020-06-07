package com.example.registerspringappdatabase.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {
	
	@Id
	private String uname;
	private String name;
	private String email;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public UserModel(String uname, String name, String email) {
		super();
		this.uname = uname;
		this.name = name;
		this.email = email;
	}
	public UserModel() {
	}
	@Override
	public String toString() {
		return "UserModel [uname=" + uname + ", name=" + name + ", email=" + email + "]";
	}
	
	

	
}
