package com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		long mobilenumber=Long.parseLong(req.getParameter("mobilenumber"));
		String address=req.getParameter("address");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernateservlet","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into hr values(?,?,?,?,?)");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setLong(4, mobilenumber);
			preparedStatement.setString(5, address);
			
			int result=preparedStatement.executeUpdate();
			if(result!=0)
			{
				System.out.println("Inserted Successfully");
			}
			else
			{
				System.out.println("Insertion Failed");
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
