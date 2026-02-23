package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Batch;
import com.jsp.dto.Student;

@WebServlet("/removestudentfrombatch")
public class RemoveStudentFromBatch extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		StudentBatchDao dao=new StudentBatchDao();
		
		int sid=Integer.parseInt(req.getParameter("sid"));
		int bid=Integer.parseInt(req.getParameter("bid"));
		
		//Batch batch=dao.fetchBatchById(bid);
		Student student=dao.fetchStudentById(sid);
		List<Batch> batches=student.getBatches();
		
		Iterator<Batch> itr=batches.iterator();
		while(itr.hasNext())
		{
			Batch batch=itr.next();
			if(batch.getBid()==bid)
			{
				itr.remove();
				out.println("<h1>Removed Successfully</h1>");
				RequestDispatcher dispatcher=req.getRequestDispatcher("viewbatchdetails");
				out.println("<button>Back To Home</button>");
				dispatcher.forward(req, resp);
			}
			break;
		}
		student.setBatches(batches);
		dao.saveStudent(student);
		
	}
}
