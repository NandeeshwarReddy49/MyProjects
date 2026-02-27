package com.bank.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bank.dto.BankCustomerDetails;

public class UpdateMobileNumberUsingId
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		int customerid=sc.nextInt();
		
		EntityManagerFactory factory=
				Persistence.createEntityManagerFactory("Bank_Management_System_By_Using_Hibernate");
	
		EntityManager manager=factory.createEntityManager();
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		BankCustomerDetails bankCustomerDetails=manager.find(BankCustomerDetails.class, customerid);
		System.out.println("Before Updation "+bankCustomerDetails);
		if(bankCustomerDetails!=null)
		{
			System.out.println("Enter MobileNumber");
			long mobilenumber=sc.nextLong();
			bankCustomerDetails.setMobilenumber(mobilenumber);
			System.out.println("After Updation "+bankCustomerDetails);
			manager.merge(bankCustomerDetails);
			transaction.commit();
			System.out.println("Mobile Number Updated");
		}
		else
		{
			System.out.println("No Data Found");
		}
	}
}
