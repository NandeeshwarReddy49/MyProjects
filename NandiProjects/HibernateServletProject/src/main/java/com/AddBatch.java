package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.StudentBatchDao;
import com.jsp.dto.Batch;

@WebServlet("/addbatch")
public class AddBatch extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Scanner sc=new Scanner(System.in);
		PrintWriter out=resp.getWriter();
		
		StudentBatchDao dao=new StudentBatchDao();
		
		int bid=Integer.parseInt(req.getParameter("bid"));
		String name=req.getParameter("trainername");
		String subject=req.getParameter("subject");
		String startdate=req.getParameter("startdate");
		String time=req.getParameter("time");
		Batch bat=dao.fetchBatchById(bid);
		if(bat==null)
		{
			Batch batch=new Batch();
			batch.setBid(bid);
			batch.setTrainername(name);
			batch.setSubject(subject);
			batch.setStartdate(startdate);
			batch.setTime(time);
			dao.saveBatch(batch);
			out.println("<h1>Batch Added Successfully</h1>");
		}
		else
		{
			out.println("<h1>Batch Already Exists </h1>");
		}
		out.println("<form action='home' method='post'>");
		out.println("<button>Back To Home</button>");
		out.println("</form>");
		
	}
}
