<%@page import="com.jsp.dto.Batch"%>
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
        margin:30px auto;
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
     #home{
            background-color: rgba(50, 78, 237, 0.385);
            color: rgb(6, 6, 7);
            width: 80px;
            height: 30px;
            border-radius: 10px;
            border: 1px solid;
        }
        #home:hover{
            background-color: black;
            color: white;
        }
        h1{
        	text-align: center; 	 	
        }
</style>
<body>
	<%
		
		StudentBatchDao dao=new StudentBatchDao();
		List<Batch> batches=dao.fetchAllBatches();
	%>
		
		<form action="home.jsp">
		<button id="home">Home</button>
		</form>
		<h1>All Batches</h1>
		<table border="2" cellspacing="0">
			<tr>
				<th>Batch Id</th>
				<th>Trainer Name </th>
				<th>Batch Details</th>
			</tr>
			<%
				for(Batch batch:batches)
				{
			%>
				<tr>
					<td><%=batch.getBid() %></td>
					<td><%=batch.getTrainername()%></td>
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
		
</body>
</html>