package com.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Batch;
import com.jsp.dto.Student;

public class StudentBatchController
{
	public static void main(String[] args)
	{
//		StudentBatchDao dao=new StudentBatchDao();
////		
//		Student student1=new Student();
//		student1.setSid(1);
//		student1.setSname("nandi");
//		student1.setEmail("nandi@gmail.com");
//		student1.setPassword("nandi@1234");
//		student1.setNumber(9876543210l);
//		
//		Student student2=new Student();
//		student2.setSid(2);
//		student2.setSname("hari");
//		student2.setEmail("hari@gmail.com");
//		student2.setPassword("hari@1234");
//		student2.setNumber(77274524520l);
//		
		StudentBatchDao dao=new StudentBatchDao();
		
		Student student=new Student();
		List<Student> students=new ArrayList<Student>();
		students.add(student);
		
		Batch batch=new Batch();
//		batch1.setBid(121);
//		batch1.setTrainername("pavan");
//		
//		Batch batch2=new Batch();
//		batch2.setBid(122);
//		batch2.setTrainername("ravan");
//		
		List<Batch> batches=new ArrayList<Batch>();
		batches.add(batch);
//		batches.add(batch2);
//		
		student.setBatches(batches);
		
		
		batch.setStudents(students);
		
//		
//		
//		
//		dao.saveBatch(batch1);
//		dao.saveBatch(batch2);
		
	}
}
