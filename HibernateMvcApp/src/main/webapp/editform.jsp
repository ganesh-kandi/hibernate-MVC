<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body bgcolor='lightblue'>
<br/><br/><br/>
<center>
<c:set var="result" value="${requestScope.student}"></c:set>


	<c:choose>
		<c:when test="${ result ne null}">
		<form method="get" action="../controller/update">
			<table border="1">
				<tr>
				<th>ID</th><td>${result.sid }</td>
				</tr>
				<input type='hidden' name='sid' value='${result.sid }'/>
				
				<tr>
				<th>NAME</th><td>
				<input type='text' name='name' value='${result.name }'/>
				</td>
				</tr>
				<tr>
				<th>CITY</th><td>
				<input type='text' name='city' value='${result.city }'/>
				</td>
				</tr>
				<tr>
				<th>EMAIL</th><td>
				<input type='text' name='email' value='${result.email }'/>
				</td>
				</tr>
				<tr>
				<th>COUNTRY</th><td>
				<input type='text' name='country' value='${result.country }'/>
				</td>
				</tr>
				
				<tr>
				<td></td>
				<td><input type='submit' value='update'/>
				</td>
				</tr>
				
			</table>
		</form>
		</c:when>
		
		<c:when test="${result eq null }">
			<h1 style='color:red; text-align:center;'>RECORD NOT FOUND WITH GIVEN ID 
			</h1>
		</c:when>
	</c:choose>
	
	
	
	
	</center>

	
</body>
</html>