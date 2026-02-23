<%@page import="com.jsp.dto.Student"%>
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
        padding: 0;
        margin: 0;
    }
    body{
        background-color: rgba(218, 187, 120, 0.671);
    }
    form{
        height: 400px;
        width: 500px;
        border: none;
        border-radius: 10px;
        margin: 90px auto;
        display: flex;
        align-items: center;
        flex-direction: column;
        justify-content: center;
        gap: 13px;
        padding: 30px;
        background-color: rgba(234, 180, 74, 0.671);
        box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
    }
    table{
        height: 300px;
        width: 400px;
        border: none;
    }
    input{
        padding: 10px 10px;
        width: 240px;
        outline: none;
        border: none;
        border-radius: 10px;
        
    }
    input:focus{
        border-color: aqua;
        border: 1px solid;
    
    }
   
    p{
        margin-top: 20px;
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    }
    a{
       font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    }
    button{
        width: 120px;
        padding: 8px 15px;
        margin-top: 20px;
        
        font-weight: bold;
        background-color: rgb(211, 126, 230);
        outline: none;
        border: none;
        border-radius: 10px;
        
    }
    button:hover{
        background-color: rgba(94, 86, 73, 0.553);
        color: white;
    }
    .headings,h1{
        font-weight: bold;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    h1{
        text-decoration: underline;
    }
   
</style>
</head>
<body>
	<%
		StudentBatchDao dao=new StudentBatchDao();
		int id=Integer.parseInt(request.getParameter("sid"));
		Student student=dao.fetchStudentById(id);
	%>
	<form action='updatestudent' method='post'>
            <h1>Edit Student Details</h1>
	    <table>
			<tr>
				<td class="headings">Id :</td>
				<td><input type='text' name='sid' value="<%=student.getSid() %>" readonly></td>
			</tr>
            <tr>
                <td class="headings">Name :</td>
                <td><input type='text' name='sname' value="<%=student.getSname() %>"></td>
            </tr>
            <tr>
                <td class="headings">Email :</td>
                <td><input type='email' name='email' value="<%=student.getEmail() %>"></td>
            </tr>
            <tr>
                <td class="headings">Password :</td>
                <td><input type='password' name='password' value="<%=student.getPassword()%>"></td>
            </tr>
            <tr>
              <td class="headings">Mobile Number :</td>
              <td><input type='text' name='number' value="<%=student.getNumber()%>"></td>
            </tr>
            <tr>
            <td><button>Update</button></td>
            <td>
            	<form action="home.jsp">
            	<button>Cancel</button>
            	</form>
			</td>
            </tr>
            
		</table>
		
	</form>
	
</body>
</html>