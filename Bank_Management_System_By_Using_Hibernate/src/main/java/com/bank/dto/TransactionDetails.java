package com.bank.dto;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_details")
public class TransactionDetails 
{
	@Id
	@Column(name="Transaction_Id")
	private int id;
	@Column(name="Transaction_Type",nullable=false)
	private String transcationtype;
	@Column(name="Transaction_Date",nullable=false)
	private Date date;
	@Column(name="Transaction_Time",nullable=false)
	private Time time;
	@Column(name="Transaction_Amount",nullable=false)
	private double amount;
	@Column(name="Balance",nullable=false)
	private double balance;
	@Column(name="Account_Number",nullable=false)
	private long accountnumber;
	
	public TransactionDetails()
	{
		
	}

	public TransactionDetails(int id, String transcationtype, Date date, Time time, double amount, double balance,
			long accountnumber) {
		super();
		this.id = id;
		this.transcationtype = transcationtype;
		this.date = date;
		this.time = time;
		this.amount = amount;
		this.balance = balance;
		this.accountnumber = accountnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTranscationtype() {
		return transcationtype;
	}

	public void setTranscationtype(String transcationtype) {
		this.transcationtype = transcationtype;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", transcationtype=" + transcationtype + ", date=" + date + ", time="
				+ time + ", amount=" + amount + ", balance=" + balance + ", accountnumber=" + accountnumber + "]";
	}
	
}
