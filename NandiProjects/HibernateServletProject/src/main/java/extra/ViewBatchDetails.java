package extra;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Batch;
import com.jsp.dto.Student;

@WebServlet("/viewbatchdetails")
public class ViewBatchDetails extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		StudentBatchDao dao=new StudentBatchDao();
		int bid=Integer.parseInt(req.getParameter("bid"));
		Batch batch=dao.fetchBatchById(bid);
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Batch Id :"+batch.getBid()+"</h3>");
		out.println("<h3>Trainer Name :"+batch.getTrainername()+"</h3>");
		out.println("<h3>Subject Name :"+batch.getSubject()+"</h3>");
		out.println("<h3>Start Date :"+batch.getStartdate()+"</h3>");
		out.println("<h3>Class Time :"+batch.getTime()+"</h3>");
		
		List<Batch> batches=dao.fetchAllBatches();
		List<Student> students = null;
		for(Batch bat:batches)
		{
			if(bid==bat.getBid())
			{
				students=bat.getStudents();
			}
		}
		out.println("<h1>Assigned Students</h1>");
		out.println("--------------------------------");
		for(Student student:students)
		{
			out.print("<h1>"+student.getSid()+"   "+student.getSname()+"</h1>");
			
			out.println("<form action='removestudentfrombatch' method='post'>");
			out.println("<input type='text' name='sid' value='"+student.getSid()+"' hidden>");
			out.println("<input type='text' name='bid' value='"+bid+"' hidden>");
			out.println("<button> Remove </button>");
			out.println("</form>");
			
		}
		out.println("</body>");
		out.println("</html>");
		
	}
}
