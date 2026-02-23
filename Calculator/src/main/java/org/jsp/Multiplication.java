package org.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiply")
public class Multiplication extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num1=Integer.parseInt(req.getParameter("firstnumber"));
		int num2=Integer.parseInt(req.getParameter("secondnumber"));
		int muliplication=num1*num2;
		resp.sendRedirect("result?result="+muliplication);
	}
}
