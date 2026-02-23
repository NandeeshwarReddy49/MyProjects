<%@page import="com.jsp.dto.Batch"%>
<%@page import="com.jsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.dao.StudentBatchDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-color: rgb(186, 230, 241);
        }
        #table1{
           width: 1200px;
           width: fit-content;
            display: flex;
            align-items: center;
            justify-content:center;
            margin: auto;
            border: solid;
            
        }
        #table2{
           width: 450px;
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
</head>
<body>
	<%
		StudentBatchDao dao=new StudentBatchDao();
		int sid=Integer.parseInt(request.getParameter("sid"));
		Student student=dao.fetchStudentById(sid);
		List<Batch> batches=student.getBatches();
	%>
	<form action="home.jsp">
		<button id="home">Home</button>
		</form>
	<h1>Student Details</h1>
	<table id="table1" border="1" cellspacing="0">
	        
	        <tr>
	        <th>Id</th>
	        <th>Name</th>
	        <th>Email</th>
            <th>Password</th>
            <th>Mobile Number</th>
	        </tr>
	        
       	 <tr>
          	<td><%=student.getSid() %></td>
			<td><%=student.getSname() %></td>
            <td><%=student.getEmail() %></td>
            <td><%=student.getPassword() %></td>
            <td><%=student.getNumber() %></td>
            

        </tr>
        <tr>
            
            <td id="buttons" colspan="3">
			<form action='editstudent.jsp' method='post'>
			<input type='text' name='sid' value='<%=student.getSid() %>' hidden>
			<button>Update</button>
			</form>
            </td>
            <td colspan="2">
			<form action='deletestudent' method='post'>
			<input type='text' name='sid' value='<%=student.getSid() %>' hidden>
			<button> Delete </button>
			</form>
			</td>
        </tr>
        </table>
        <% 
        	if(!batches.isEmpty())
	    	{
        	%>
        		<h1>Attending Batches</h1>
    			<table id="table2" border="1" cellspacing="0">
    			<tr>
	                <th>Batch Id</th>
	                <th>Trainer Name</th>
	                <th>Details</th>
          		 </tr>
	       	<%
	       		for(Batch batch:batches)
	       		{
	       	%>
       			 <tr>
		            <td><%=batch.getBid() %></td>
		            <td><%=batch.getTrainername() %></td>
	          	 	<td>
						<form action="viewbatchdetails.jsp" method="post">
						<input type="hidden" name="bid" value="<%=batch.getBid() %>">
						<button>View</button>
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
	       	<h1>No Batches Attending</h1>
	       	<%		
	      }
	      %>
</body>
</html>