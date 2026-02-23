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
import com.jsp.dto.Batch;
import com.jsp.dto.Student;

@WebServlet("/viewdetails")
public class ViewStudentDetails extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		int id=Integer.parseInt(req.getParameter("sid"));
		StudentBatchDao dao=new StudentBatchDao();
		
		Student student=dao.fetchStudentById(id);
		List<Batch> batches=student.getBatches();
		Iterator<Batch> itr=batches.iterator();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h3> Student Id :"+student.getSid()+"</h3>");
		out.println("<h3> Student Name :"+student.getSname()+"</h3>");
		out.println("<h3> Student Email :"+student.getEmail()+"</h3>");
		out.println("<h3> Student Password :"+student.getPassword()+"</h3>");
		out.println("<h3> Student Mobile Number :"+student.getNumber()+"</h3>");
		
		out.println("<h1>Attending Batches </h1>");

		while(itr.hasNext())
		{
			Batch batch=itr.next();
			out.println("<h3> Batch Id :"+batch.getBid()+"</h3>");
			out.println("<h3> Trainer Name :"+batch.getTrainername()+"</h3>");
		}
		
		out.println("<form action='deletestudent' method='post'>");
		out.println("<input type='text' name='sid' value='"+student.getSid()+"' hidden>");
		out.println("<button>Delete Student</button>");
		out.println("</form>");
		
		out.println("<form action='editstudent.jsp' method='post'>");
		out.println("<input type='text' name='sid' value='"+student.getSid()+"' hidden>");
		out.println("<button>Edit Student</button>");
		out.println("</form>");
		
		out.println("<form action='home' method='post'>");
		out.println("<button>Back To Home</button>");
		out.println("</form>");
		
		out.println("</body>");
		out.println("</html>");
		
			
	}
}
