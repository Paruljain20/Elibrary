package com.app.elib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private boolean isLibrarian;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLibrarian() {
		return isLibrarian;
	}
	public void setLibrarian(boolean isLibrarian) {
		this.isLibrarian = isLibrarian;
	}
	public User(int id, String name, String email, String password, boolean isLibrarian) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isLibrarian = isLibrarian;
	}
	
	public User(){
		
	}

}
