<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Employee Details</title>
	</head>
	<body>
	<jsp:include page="Head01.jsp"/>
	<jsp:include page="Head02.jsp"/>
	<%-- Welcome Mr./Ms. ${ sessionScope.userFullName }  --%> <!-- Commented this line since we included the jsp:include above -->
	<!-- <a href="logout.do">Logout</a> --> 
		<table border="1">
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<tr>
				<td>${ requestScope.empDetails.empId }</td>
				<td>${ requestScope.empDetails.firstName }</td>
				<td>${ requestScope.empDetails.lastName }</td>
			</tr>
		</table>
		<a href="empList.do">Go back to list</a>
	</body>
</html>