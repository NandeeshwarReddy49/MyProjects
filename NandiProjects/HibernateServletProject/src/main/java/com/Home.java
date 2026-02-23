package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		out.println("<form method='post' action='displayallbatches.jsp'>");
		out.println("<button>displayallbatches</button>");
		out.println("</form>");
		out.println("<form method='post' action='addstudentform.html'>");
		out.println("<button>Addstudent</button>");
		out.println("</form>");
		out.println("<form method='post' action='displayallstudents.jsp'>");
		out.println("<button>displayallstudents</button>");
		out.println("</form>");
		out.println("<form method='post' action='assignbatchstudent.jsp'>");
		out.println("<button>assignbatchtostudent</button>");
		out.println("</form>");
		out.println("<form method='post' action='addbatch.html'>");
		out.println("<button>Add New Batch</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
