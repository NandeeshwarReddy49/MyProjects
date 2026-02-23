package com.jsp.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Batch;
import com.jsp.dto.Student;


public class StudentBatchDao 
{
	
	Scanner sc=new Scanner(System.in);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernateservlet");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void saveStudent(Student student)
	{
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	public void saveBatch(Batch batch)
	{
		entityTransaction.begin();
		entityManager.persist(batch);
		entityTransaction.commit();
	}
	public List<Student> fetchAllStudents()
	{
		Query query=	entityManager.createQuery("select s from Student s");
		List<Student> students=query.getResultList();
		return students;	
	}
	public List<Batch> fetchAllBatches()
	{
		Query query=entityManager.createQuery("select b from Batch b");
		List<Batch> batches=query.getResultList();
		return batches;
	}
	public void deleteStudent(int id)
	{
		Student student=entityManager.find(Student.class, id);
		if(student.getSid()==id)
		{
			entityTransaction.begin();
			student.setBatches(null);
			entityManager.remove(student);
			entityTransaction.commit();
		}
	}
	public Batch fetchBatchById(int bid)
	{
		Batch batch=entityManager.find(Batch.class, bid);
		return batch;
	}
	public Student fetchStudentById(int id)
	{
		Student student=entityManager.find(Student.class, id);
		return student;	
	}
	public void updateStudent(Student student)
	{
		String name=student.getSname();
		int id=student.getSid();
		String email=student.getEmail();
		String password=student.getPassword();
		long number=student.getNumber();
		Query query=entityManager.createQuery("update Student set sname= :name,email= :email,password= :password,number= :number where sid= :id");
		query.setParameter("name", name);
		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("number", number);
		query.setParameter("id", id);
		entityTransaction.begin();
		int result=query.executeUpdate();
		entityTransaction.commit();
	}
	public void addStudent(int id)
	{
		
		System.out.println("Enter Student Name");
		String name=sc.next();
		System.out.println("Enter Student Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		System.out.println("Enter Mobile Number");
		long number=sc.nextLong();
		Student student=new Student();
		student.setSid(id);
		student.setSname(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setNumber(number);
		saveStudent(student);
	}
}
