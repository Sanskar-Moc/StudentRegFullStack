<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful</title>
<style>
    body {
        display: flex;
        flex-direction:column;
        justify-content: center;
        align-items: center;
        height:100vh;
      
    }
    .container{
    	border: 2px solid black;
    	padding: 10px;
    }
    .details {
        text-align: left;
    }
</style>
</head>
<body>
   <div class="container">
        <div class="details">
            <h3>Registered Successfully</h3>
            <p>Id: ${student.id}</p>
            <p>Name: ${student.name}</p>
            <p>Age: ${student.age}</p>
            <p>Mobile: ${student.mobile}</p>
            <p>Address: ${student.address}</p>
        </div>
    </div>	
</body>
</html>