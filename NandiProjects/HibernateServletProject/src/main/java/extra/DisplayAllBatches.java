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

@WebServlet("/displaybatches")
public class DisplayAllBatches extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		StudentBatchDao dao=new StudentBatchDao();
		List<Batch> batches=dao.fetchAllBatches();
	
		if(batches!=null)
		{
			for(Batch batch:batches)
			{
				out.println("<html>");
				out.println("<body>");
				out.println("<form action='viewbatchdetails' method='post'>");
				out.println("<input type='text' name='bid' value='"+batch.getBid()+"' hidden>");
				out.println("<h1>"+batch.getBid()+"   "+batch.getTrainername()+"   <button>View</button></h1>");
				
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
			}
			
		}
		else
		{
			out.println("<h1>No Batches Found</h1>");
		}
	}
}
