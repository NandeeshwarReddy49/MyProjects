package com.bank.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_customer_details")
public class BankCustomerDetails
{
	@Id
	@Column(name="Customer_Id")
	private int customerId;
	@Column(name="Customer_Name",nullable=false)
	private String name;
	@Column(name="Customer_Mobile_Number",unique = true,nullable = false)
	private long mobilenumber;
	@Column(name="Customer_Aadhar_Number",unique = true,nullable = false)
	private long aadharnumber;
	@Column(name="Customer_Pan_Number",unique = true,nullable = false)
	private String pannumber;
	@Column(name="Customer_Email_Id",unique = true,nullable = false)
	private String emailid;
	@Column(name="Customer_Address",nullable = false)
	private String address;
	@Column(name="Customer_Designation",nullable = false)
	private String designation;
	@Column(name="Customer_Account_Number",unique = true,nullable = false)
	private long accountnumber;
	@Column(name="Customer_Pin",nullable = false)
	private int pin;
	@Column(name="IFSC_Code",nullable = false)
	private String ifsccode;
	@Column(name="Branch",nullable = false)
	private String branch;
	@Column(name="Type_Of_Account",nullable = false)
	private String typeofaccount;
	@Column(name="Amount",nullable = false)
	private double amount;
	@Column(name="Gender",nullable = false)
	private String gender;
	
	public BankCustomerDetails()
	{
		
	}

	public BankCustomerDetails(int customerId, String name, long mobilenumber, long aadharnumber, String pannumber,
			String emailid, String address, String designation, long accountnumber, int pin, String ifsccode,
			String branch, String typeofaccount, double amount, String gender) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.aadharnumber = aadharnumber;
		this.pannumber = pannumber;
		this.emailid = emailid;
		this.address = address;
		this.designation = designation;
		this.accountnumber = accountnumber;
		this.pin = pin;
		this.ifsccode = ifsccode;
		this.branch = branch;
		this.typeofaccount = typeofaccount;
		this.amount = amount;
		this.gender = gender;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public long getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTypeofaccount() {
		return typeofaccount;
	}

	public void setTypeofaccount(String typeofaccount) {
		this.typeofaccount = typeofaccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "BankCustomerDetails [customerId=" + customerId + ", name=" + name + ", mobilenumber=" + mobilenumber
				+ ", aadharnumber=" + aadharnumber + ", pannumber=" + pannumber + ", emailid=" + emailid + ", address="
				+ address + ", designation=" + designation + ", accountnumber=" + accountnumber + ", pin=" + pin
				+ ", ifsccode=" + ifsccode + ", branch=" + branch + ", typeofaccount=" + typeofaccount + ", amount="
				+ amount + ", gender=" + gender + "]";
	}
	
	
	
}
