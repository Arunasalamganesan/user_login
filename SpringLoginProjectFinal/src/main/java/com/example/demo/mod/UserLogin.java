package com.example.demo.mod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserLogin_table", catalog = "springbootdb")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String user_name;
	private String password;
	private String mobilenumber;

	public UserLogin(int id, String user_name, String password, String mobilenumber) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.mobilenumber = mobilenumber;
	}

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
}
