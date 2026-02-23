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

@WebServlet("/studentbatchform")
public class AssigningBatchStudentform extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		StudentBatchDao dao=new StudentBatchDao();
		
		List<Batch> batches=dao.fetchAllBatches();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<form action='assignbatch' method='post'>");
		out.print("<label>Student Id:</label>");
		out.println("<input type='text' name='sid'>");
		out.print("<label>Batch Id:</label>");
		out.println("<input type='text' name='bid'>");
		out.println("<button>Assign</button>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		
	}
}
