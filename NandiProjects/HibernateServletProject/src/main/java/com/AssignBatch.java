package com;

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

@WebServlet("/assignbatch")
public class AssignBatch extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		StudentBatchDao dao=new StudentBatchDao();
		
		int sid=Integer.parseInt(req.getParameter("sid"));
		int bid=Integer.parseInt(req.getParameter("bid"));
		
		
		
		Student student=dao.fetchStudentById(sid);
		Batch batch=dao.fetchBatchById(bid);
		List<Batch> batches=student.getBatches();
		Iterator<Batch> itr=batches.iterator();
		
		boolean assigned=false;
		if(student!=null&&batch!=null)
		{
			while(itr.hasNext())
			{
				Batch batch2=itr.next();
				if(batch2.getBid()==bid)
				{
					assigned=true;
				}
			}
		}
		else
		{
			out.print("<h1>Invalid Student Id Or Batch Id");
		}
		if(assigned)
		{
			out.println("<h1>Student Already Exists....");
		}
		else
		{
			batches.add(batch);
			dao.saveStudent(student);
			out.println("<h1>Assigned Successfully</h1>");
		}
		
		

		
		
		
		
	}
}
