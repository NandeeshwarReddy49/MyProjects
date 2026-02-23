package com.jsp.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Batch;
import com.jsp.dto.Student;

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		PrintWriter out=resp.getWriter();
		Scanner sc =new Scanner(System.in);
		StudentBatchDao dao=new StudentBatchDao();
		
		int id=Integer.parseInt(req.getParameter("sid"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long number=Long.parseLong(req.getParameter("number"));
		
		Student stu=dao.fetchStudentById(id);
		if(stu==null)
		{
			Student student=new Student();
			student.setSid(id);
			student.setSname(name);
			student.setEmail(email);
			student.setPassword(password);
			student.setNumber(number);
			dao.saveStudent(student);
			out.print("<h1>Student Added Successfully</h1>");
			out.println("<form action='home.jsp' method='post'>");
			out.println("<button>Back To Home</button>");
			out.println("</form>");
		}
		else
		{
			out.println("<h1>Student Id Already Exists Try Again</h1>");
			out.println("<form action='addstudentform.html' method='post'>");
			out.println("<button>Try Again</button>");
			out.println("</form>");
		}
	}
}
