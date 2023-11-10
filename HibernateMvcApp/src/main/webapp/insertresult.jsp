<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body>
<center/>
<h1>
<c:set var="result" value="${requestScope.insert}"></c:set>
	<c:choose>
		<c:when test="${ result eq 's'}">
			<h1 style='color:green; test-align:center;'>INSERT OPERATION IS DONE SUCCESSFULLY</h1>
		</c:when>
		<c:when test="${ result eq 'f'}">
			<h1 style='color:red; test-align:center;'>INSERT OPERATION IS FAILED</h1>
		</c:when>
		<c:when test="${ result eq 'fnf'}">
			<h1 style='color:blue; test-align:center;'>USER NOT FOUND TO GIVEN ID</h1>
		</c:when>
		
	</c:choose>
</h1>
	
</body>
</html>