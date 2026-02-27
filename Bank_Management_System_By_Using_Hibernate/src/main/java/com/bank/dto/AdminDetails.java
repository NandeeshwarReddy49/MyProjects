package com.bank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="admin_details")
public class AdminDetails 
{
	@Id
	@Column(name="Admin_Id")
	private int adminid;
	@Column(name="Email_Id",unique=true,nullable = false)
	private String emailid;
	@Column(name="Password",nullable = false)
	private String password;
	
	public AdminDetails()
	{
		
	}

	public AdminDetails(int adminid, String emailid, String password) {
		super();
		this.adminid = adminid;
		this.emailid = emailid;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDetails [adminid=" + adminid + ", emailid=" + emailid + ", password=" + password + "]";
	}
	
}
