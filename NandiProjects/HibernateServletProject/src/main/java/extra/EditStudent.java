package extra;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Student;

@WebServlet("/editstudent")
public class EditStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		StudentBatchDao dao=new StudentBatchDao();
		
		int id=Integer.parseInt(req.getParameter("sid"));
		Student student=dao.fetchStudentById(id);
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='updatestudent' method='post'>");
		out.println(" Student Id :<input type='text' name='sid' value='"+student.getSid()+"' readonly>");
		out.println(" Student Id :<input type='text' name='sname' value='"+student.getSname()+"'><br>");
		out.println(" Student Id :<input type='email' name='email' value='"+student.getEmail()+"'><br>");
		out.println(" Student Id :<input type='password' name='password' value='"+student.getPassword()+"'><br>");
		out.println(" Student Id :<input type='tel' name='number' value='"+student.getNumber()+"'><br>");
		out.println("<button>Update</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
