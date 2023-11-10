<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>getting password</title>
<style>
.button {
			display: flex;
			align-items: center;
			justify-content: center;
			width: 200px;
			height: 30px;
			margin: 20px; 
			border-radius: 15px;
			background-color: #0000CD;
			color: white;
			font-size: 1.30em;
			font-weight: bold;
			text-transform: uppercase;
			text-align: center;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
			cursor: pointer;
			transition: transform 0.2s ease-in-out;
            text-decoration: none;
		}
.button:hover {
			transform: scale(1.05);
			box-shadow: 0 0 20px rgb(242, 242, 242);
		}
		

</style>
</head>
<center/>
<body>

	<div class="form1">
	<%
        String status = (String)session.getAttribute("pass");
	%>
			<h1 style="color:white"> Your Password is </h1>
			
			<h1 style="color:#00FF7F"><%= status%>  </h1>
			
			<a href="login.jsp" class="button"><h5>Login Page</h5></a>
	</div>
</body>
</html>