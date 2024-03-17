<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        width: 400px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    label {
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }
    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        border: none;
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
<!-- 	<h1>Employee Registration Form</h1> -->
<!-- 	<a href="changeLocale.htm?lang=en">English</a> -->
<!-- 	<a href="changeLocale.htm?lang=es">Spanish</a> -->
<%-- 	<form method="POST" action="saveemp.htm"> --%>
<!-- 		<br /> -->
<!-- 		 ID: <input type="text" name="eid" /> <br />  -->
<!-- 		 FirstName: <input type="text" name="fname" /> <br />  -->
<!-- 		 LastName: <input type="text" name="lname" /> <br />  -->
<!-- 		 <input type="submit" value="Save Employee" /> <br /> -->
<%-- 	</form> --%>
<div class="container">
    <h2 style="text-align:center;">Student Registration Form</h2>
    <form id="registrationForm" action="saveStudent" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        
        <label for="age">Age:</label>
        <input type="text" id="age" name="age" required>
        
        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobile" required>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required>
        
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</div>
</body>
</html>