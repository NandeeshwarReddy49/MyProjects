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
        background-color: rgb(212, 124, 190);
    }
    form{
        height: 300px;
        width: 400px;
        border: none;
        border-radius: 10px;
        margin: 90px auto;
        display: flex;
        align-items: center;
        flex-direction: column;
        justify-content: center;
        gap: 13px;
        background-color: rgba(243, 117, 220, 0.967);
        box-shadow: rgba(14, 30, 37, 0.12) 0px 2px 4px 0px, rgba(14, 30, 37, 0.32) 0px 2px 16px 0px;
    }
    input{
        padding: 10px 20px;
        width: 250px;
        outline: none;
        border: none;
        border-radius: 10px;
    }
    input:focus{
        border-color: rgb(236, 8, 202);
        border: 2px solid;
    
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
        background-color: rgb(108, 249, 8);
        outline: none;
        border: none;
        border-radius: 10px;
        
    }
    button:hover{
        background-color: rgba(0, 0, 0, 0.553);
        color: aliceblue;
    }
</style>
</head>
<body>
	<form action='assignbatch' method='post'>
		<!-- <label>Student Id:</label> -->
		<input type='text' name='sid' placeholder="Student ID">
		<!-- <label>Batch Id:</label> -->
		<input type='text' name='bid' placeholder="Batch ID">
		<button>Assign</button>
	</form>
</body>
</html>