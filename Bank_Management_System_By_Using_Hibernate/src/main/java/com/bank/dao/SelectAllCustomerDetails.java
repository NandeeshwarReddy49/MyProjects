package com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bank.dto.BankCustomerDetails;

public class SelectAllCustomerDetails 
{
	public static void main(String[] args) 
	{
		String select="select customer BankCustomerDetails customer";
		
		EntityManagerFactory factory=
				Persistence.createEntityManagerFactory("Bank_Management_System_By_Using_Hibernate");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		
		Query query=manager.createQuery(select);
			List<BankCustomerDetails> resultList=query.getResultList();
			System.out.println(resultList);
		for(BankCustomerDetails details:resultList)
		{
			System.out.println("Customer Id :"+details.getCustomerId());
			System.out.println("Customer Aadhar number :"+details.getAadharnumber());
			System.out.println("Customer Account Number :"+details.getAccountnumber());
			System.out.println("Customer Address :"+details.getAddress());
			System.out.println("Customer Amount :"+details.getAmount());
			System.out.println("Customer branch :"+details.getBranch());
			System.out.println("Customer Designation :"+details.getDesignation());
			System.out.println("Customer EmailId :"+details.getEmailid());
			System.out.println("Customer Gender :"+details.getGender());
			System.out.println("Customer IFSC :"+details.getIfsccode());
			System.out.println("Customer Mobile :"+details.getMobilenumber());
			System.out.println("Customer Name :"+details.getName());
			System.out.println("Customer PAN Number :"+details.getPannumber());
			System.out.println("Customer PIN :"+details.getPin());
			System.out.println("Customer Type Of Account :"+details.getTypeofaccount());
			
		}
	}
}
