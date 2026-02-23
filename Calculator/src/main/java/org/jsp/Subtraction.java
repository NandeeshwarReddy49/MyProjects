package org.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subtract")
public class Subtraction extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num1=Integer.parseInt(req.getParameter("firstnumber"));
		int num2=Integer.parseInt(req.getParameter("secondnumber"));
		int subtract=num1-num2;
		resp.sendRedirect("result?result="+subtract+"");
	}
}
