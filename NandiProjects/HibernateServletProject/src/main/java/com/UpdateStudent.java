package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Student;

@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("sid"));
		String name=req.getParameter("sname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long number=Long.parseLong(req.getParameter("number"));
		Student student=new Student();
		student.setSid(id);
		student.setSname(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setNumber(number);
		StudentBatchDao dao=new StudentBatchDao();
		dao.updateStudent(student);
		RequestDispatcher dispatcher=req.getRequestDispatcher("viewdetails");
		dispatcher.forward(req, resp);
	}
}
