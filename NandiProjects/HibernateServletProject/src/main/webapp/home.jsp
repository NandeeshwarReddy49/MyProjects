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
        background-color: rgb(178, 240, 97);
    }
    div{
        height: 250px;
        width: 300px;
        margin: 50px auto;
        border: none;
        display: flex;
        flex-direction: column;
        justify-content: space-evenly;
        background-color: rgb(169, 231, 93);
       
        box-shadow: rgba(0, 0, 0, 0.25) 0px 0.0625em 0.0625em, rgba(0, 0, 0, 0.25) 0px 0.125em 0.5em, rgba(255, 255, 255, 0.1) 0px 0px 0px 1px inset;
       border-radius: 20px; 
    }   
    button{
        width: 100%;
        padding: 10px;
        background-color: rgb(175, 230, 212);
        font-weight: bold;
        font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        border-radius: 10px;

    }
    button:hover{
        background-color: aqua;
    }
    h1{
        display: flex;
        margin: auto;
        justify-content: center;
        margin-top: 100px;
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    }
</style>
<body>
		
	<h1>Welcome......</h1>
		<div>
            <form method='post' action='displayallbatches.jsp'>
		<button>Display All Batches</button>
		</form>
		<form method='post' action='addstudentform.html'>
		<button>Add New Student</button>
		</form>
		<form method='post' action='displayallstudents.jsp'>
		<button>Display All Students</button>
		</form>
		<form method='post' action='assignbatchstudent.jsp'>
		<button>Assign Batch to Student</button>
		</form>
		<form method='post' action='addbatch.html'>
		<button>Add New Batch</button>
		</form>
        </div>
</body>
</html>