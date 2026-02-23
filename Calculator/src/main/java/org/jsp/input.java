package org.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/one")
public class input extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String button=req.getParameter("operation");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='"+button+"' method='get'>");
		out.println("Enter first Number :<input type='number' name='firstnumber'></br>");
		out.println("Enter second Number :<input type='number' name='secondnumber'></br>");
		out.println("<button>"+button+"</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
