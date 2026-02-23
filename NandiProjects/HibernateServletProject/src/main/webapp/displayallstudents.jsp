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
</head>
<style>

    *{
        padding: 0;
        margin: 0;
    }
    body{
        background-color: rgb(168, 223, 223);

    }
    table{
     
        width: 400px;
        display: flex;
        margin: auto;
        border:  1px solid rgba(0, 0, 0, 0.515);
        background-color: rgb(104, 253, 253);
        text-align: left;
        justify-content: center;
        
    }
    th{
        padding: 10px;
        width: 300px;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    td{
        padding: 10px;
         font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    }
    button{
        width: 80px;
        padding:5px;
        background-color: rgb(195, 209, 209);
        font-weight: bold;
        border: 1px solid black;
        border-radius: 5px;
        
    }
    button:hover{
        background-color: rgb(164, 242, 242);
        font-weight: bold;
    }
    h1{
    	text-align: center;
    	font-family: sans-serif;
    	margin-top:30px;
    	margin-bottom:10px;
    	text-decoration:underline;
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
		List<Student> students=dao.fetchAllStudents();
	%>
	<form action="home.jsp">
		<button id="home">Home</button>
		</form>
	<h1>Student List</h1>
		<table border="2" cellspacing="0">
			<tr>
				<th>Student Id</th>
				<th>Name </th>
				<th>Student Details</th>
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
				</tr>
			<%
				}
			%>	
		</table>
</body>
</html>