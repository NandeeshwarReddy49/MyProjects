package extra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Student;

@WebServlet("/displayallstudents")
public class DisplayAllStudents extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter out=resp.getWriter();
		
		StudentBatchDao dao=new StudentBatchDao();
		List<Student> students=dao.fetchAllStudents();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table>");
		out.println("");
		for(Student student:students)
		{
		
			out.println("<tr>");
			out.println("<form action='viewdetails' method='post'>");
			out.println("<td>"+student.getSid()+"</td>");
			out.println("<td>"+student.getSname()+"</td>");
			out.println("<td><button>View</button></td>");
			out.println("</form>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
