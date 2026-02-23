<%@page import="com.jsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.Batch"%>
<%@page import="com.jsp.dao.StudentBatchDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-color: rgb(186, 230, 241);
        }
        #table1{
           width: 700px;
            display: flex;
            align-items: center;
            justify-content:center;
            margin: auto;
            border: solid;
            

            
        }
        #table2{
           width: 880px;
           width: fit-content;
            display: flex;
            align-items: center;
            justify-content:center;
            margin: auto;
            border: solid;
            
        }
        h1{
            text-align: center;
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
            margin-top: 30px;
            margin-bottom: 10px;
            
        }
        th{
            width: 130px;
            padding: 10px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        tr{
          text-align: center;
          font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
         
        }
        td{
            padding: 10px;
        }
        button{
        	padding: 4px 5px;
            width: 100px;
            border-radius: 6px;
            font-weight: bold;

        }
        button:hover{
            background-color: rgb(111, 162, 244);
            
        }
        #home{
            background-color: rgba(50, 78, 237, 0.385);
            color: rgb(6, 6, 7);
            width: 80px;
            height: 30px;
            border-radius: 10px;
            border: 1px solid;
            position: fixed;
        }
        #home:hover{
            background-color: black;
            color: white;
        }
    </style>
<body>
		<%
			StudentBatchDao dao=new StudentBatchDao();
			int bid=Integer.parseInt(request.getParameter("bid"));
			Batch batch=dao.fetchBatchById(bid);
		%>
		<form action="home.jsp">
		<button id="home">Home</button>
		</form>
		<table id="table1" border="2" cellspacing="0">
	        <h1>Batch Details</h1>
	        <th>Batch Id</th>
	        <th>Trainer Name</th>
	        <th>Subject Name</th>
	        <th>Start Date</th>
	        <th>Time</th>
       	 <tr>
            <td><%=batch.getBid() %></td>
            <td><%=batch.getTrainername() %></td>
            <td><%=batch.getSubject() %></td>
            <td><%=batch.getStartdate() %></td>
            <td><%=batch.getTime() %></td>
        </tr>
    </table>
    <%
    		List<Student> students=null;
    		List<Batch> batches=dao.fetchAllBatches();
    		for(Batch bat:batches)
    		{
    			if(bat.getBid()==bid)
    			{
    				students=bat.getStudents();
    			}
    		}
    		if(!students.isEmpty())
    		{
    	%>
    		<table id="table2" border="2" cellspacing="0">
	        <h1>Attending Students</h1>
	        <tr>
	        <th>Student Id</th>
	        <th>Student Name</th>
	        <th>Student Details</th>
	        <th>Update Student</th>
	        <th>Delete Student</th>
	        </tr>
    	<% 
    			for(Student student:students)
    			{
    	%>
    				
	        
       	 <tr>
          	<td><%=student.getSid() %></td>
			<td><%=student.getSname() %></td>
			<td>
			<form action="viewstudents.jsp" method="post">
			<input type="hidden" name="sid" value="<%=student.getSid() %>">
			<button>View</button>
			</form>
			</td>
			<td>
			<form action='editstudent.jsp' method='post'>
			<input type='text' name='sid' value='<%=student.getSid() %>' hidden>
			<button>Update</button>
			</form>
			</td>
            <td>
			<form action='removestudentfrombatch' method='post'>
			<input type='text' name='sid' value='<%=student.getSid() %>' hidden>
			<input type='text' name='bid' value='<%=batch.getBid() %>' hidden>
			<button> Remove </button>
			</form>
			</td>
        </tr>
    		
    	<%
    			
    			}
    	%>
    	</table>
    	<%
    		}
    		else
    		{
    	%>
    		<h1>No Students Attending</h1>
    	<% 		
    		}
    %>
</body>
</html>