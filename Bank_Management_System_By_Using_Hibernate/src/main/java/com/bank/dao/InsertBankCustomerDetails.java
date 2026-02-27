package com.bank.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bank.dto.BankCustomerDetails;

public class InsertBankCustomerDetails 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter CustomerId");
		int id=sc.nextInt();
		System.out.println("Enter Customer Name");
		String name=sc.next();
		System.out.println("Enter Mobile number");
		long mobilenumber=sc.nextLong();
		System.out.println("Enter Aadhar number");
		long aadharnumber=sc.nextLong();
		System.out.println("Enter PAN Number");
		String pannumber=sc.next();
		System.out.println("Enter Emailid");
		String emailid=sc.next();
		System.out.println("Enter Address");
		String address=sc.next();
		System.out.println("Enter Designation");
		String designation=sc.next();
		System.out.println("Enter Account number");
		long accountnumber=sc.nextLong();
		System.out.println("Enter PIN");
		int pin=sc.nextInt();
		System.out.println("Enter IFSC");
		String ifsc=sc.next();
		System.out.println("Enter Branch");
		String branch=sc.next();
		System.out.println("Enter Typeof Account");
		String typeofaccount=sc.next();
		System.out.println("Enter Amount");
		double amount=sc.nextDouble();
		System.out.println("Enter Gender");
		String gender=sc.next();
		
		BankCustomerDetails bankCustomerDetails=new BankCustomerDetails(id, name, mobilenumber, aadharnumber, pannumber, emailid, address, designation, accountnumber, pin, ifsc, branch, typeofaccount, amount, gender);
	EntityManagerFactory factory=
			Persistence.createEntityManagerFactory("Bank_Management_System_By_Using_Hibernate");		
	
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		manager.persist(bankCustomerDetails);
		transaction.commit();
	}
}
